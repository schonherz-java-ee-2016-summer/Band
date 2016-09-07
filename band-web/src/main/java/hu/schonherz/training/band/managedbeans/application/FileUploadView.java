package hu.schonherz.training.band.managedbeans.application;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import hu.schonherz.training.band.managedbeans.view.DemoMB;
import hu.schonherz.training.band.service.DemoService;
import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "fileUploadViewBean")
public class FileUploadView {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadView.class);

    @EJB
    private DemoService demoService;

    @ManagedProperty(value = "#{demoBean}")
    private DemoMB demoMB;

    private String destination = "C:\\1\\";

    public void upload(FileUploadEvent event) {

        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            System.out.println("WOW: " + event.getFile().getContentType() + "   " + event.getFile().getFileName() + "   " + destination);
            demoMB.getDemoVo().setFilename(destination);
            demoMB.getDemoVo().setName(event.getFile().getFileName());
            demoMB.getDemoVo().setBandId((long) 1);

            LOGGER.info("BBBBBBBBBBBBBBBBBBBBBB " + demoMB.getDemoVo().getBandId());
            LOGGER.info("AAAAAAAAAAAAAAAAAAAAAA " + demoMB.getDemoVo().getFilename());
            demoService.createDemo(demoMB.getDemoVo());
            LOGGER.info("BBBBBBBBBBBBBBBBBBBBBB " + demoMB.getDemoVo().getBandId());
            LOGGER.info("AAAAAAAAAAAAAAAAAAAAAA " + demoMB.getDemoVo().getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    public DemoMB getDemoMB() {
        return demoMB;
    }

    public void setDemoMB(DemoMB demoMB) {
        this.demoMB = demoMB;
    }
}
