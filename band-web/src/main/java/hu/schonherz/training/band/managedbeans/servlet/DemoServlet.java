package hu.schonherz.training.band.managedbeans.servlet;

import org.apache.commons.io.FileUtils;
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
        try (ServletOutputStream stream = resp.getOutputStream()){
            String query = req.getQueryString();
            if (query.indexOf("filename=") == -1){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } else {
                String filename = query.substring(query.indexOf("filename=") + 9);
                filename = URLDecoder.decode(filename, "UTF-8");
                String[] strings = filename.split("&");
                filename = strings[0];
                filename = URLDecoder.decode(filename, "UTF-8");
                String id = query.substring(query.indexOf("id=") + 3);
                id = URLDecoder.decode(id, "UTF-8");
                strings = id.split("&");
                id = strings[0];

                LOGGER.info(System.getProperty("jboss.server.data.dir") + File.separator + "band" + File.separator +
                        id + File.separator + filename);
                File mp3 = new File(System.getProperty("jboss.server.data.dir") + File.separator + "band" + File.separator +
                        id + File.separator + filename);
                FileUtils.copyFile(mp3, stream);
                resp.setContentType("audio/mpeg");
                resp.addHeader("Content-Disposition", "attachment; filename=" + filename);
                resp.setContentLength((int) mp3.length());
                stream.close();
            }
        } catch (UnsupportedEncodingException e){
            LOGGER.error("This coding is not support!");
        } catch (FileNotFoundException e) {
            LOGGER.error("No file with this filename!");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        }
    }
}
