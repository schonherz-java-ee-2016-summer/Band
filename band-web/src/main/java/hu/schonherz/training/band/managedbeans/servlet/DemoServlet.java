package hu.schonherz.training.band.managedbeans.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;

/**
 * @author Ármin Veress
 * This servlet handles the streaming of the mp3 file.
 */
public class DemoServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream stream = null;
        BufferedInputStream buf = null;
        try {
            stream = resp.getOutputStream();
            String query = req.getQueryString();
            String filename = query.substring(query.indexOf("filename=") + 9);
            String[] strings = filename.split("&");
            filename = strings[0];
            filename = URLDecoder.decode(filename, "UTF-8");
            LOGGER.info(filename);
            File mp3 = new File(System.getProperty("jboss.server.data.dir") + File.separator + "band" + File.separator + filename);

            resp.setContentType("audio/mpeg");

            resp.addHeader("Content-Disposition", "attachment; filename=" + filename);

            resp.setContentLength((int) mp3.length());
            FileInputStream input = new FileInputStream(mp3);
            buf = new BufferedInputStream(input);
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1)
                stream.write(readBytes);
        } catch (UnsupportedEncodingException e){
            LOGGER.error("This coding is not support!");
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        } finally {
            if (stream != null)
                stream.close();
            if (buf != null)
                buf.close();
        }
    }
}
