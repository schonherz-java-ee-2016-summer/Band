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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    private String destination = System.getProperty("jboss.server.data.dir") + File.separator + "band";

    public void upload(FileUploadEvent event) {

        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            demoMB.getDemoVo().setFilename(destination);
            demoMB.getDemoVo().setName(event.getFile().getFileName());
            demoMB.getDemoVo().setBandId(1L);
            demoService.createDemo(demoMB.getDemoVo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) throws IOException {
        File destination = new File(System.getProperty("jboss.server.data.dir") + File.separator +
                "band");
        destination.mkdirs();
        Path absPath = Paths.get(destination + File.separator + fileName);

        Files.copy(in, absPath, StandardCopyOption.REPLACE_EXISTING);
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
