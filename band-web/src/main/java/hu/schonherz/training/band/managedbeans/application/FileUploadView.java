package hu.schonherz.training.band.managedbeans.application;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.DemosMB;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.DemoVo;
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

    @ManagedProperty(value = "#{bandBean}")
    private BandMB bandMB;

    @ManagedProperty(value = "#{bandDemosBean}")
    private DemosMB demosMB;

    private DemoVo demoVo;

    @EJB
    private DemoService demoService;


    private String destination = System.getProperty("jboss.server.data.dir") + File.separator + "band";

    public void upload(FileUploadEvent event) {

        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            LOGGER.info("File uploaded.");
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

        saveDemo(absPath.toString(), fileName);
    }

    public void saveDemo(String path, String name){
        demoVo = new DemoVo();
        demoVo.setName(name);
        demoVo.setFilename(path);
        demoVo.setBandId(bandMB.getBandVo().getId());
        demoService.createDemo(demoVo);
        demosMB.getDemoVos().add(demoVo);
    }

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public DemosMB getDemosMB() {
        return demosMB;
    }

    public void setDemosMB(DemosMB demosMB) {
        this.demosMB = demosMB;
    }

    public DemoVo getDemoVo() {
        return demoVo;
    }

    public void setDemoVo(DemoVo demoVo) {
        this.demoVo = demoVo;
    }

}
