package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.service.BandImageService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Attila Holhós
 * {@link BandImageUploadMB}
 * This managedBean is responsible for storing image in wildfly.
 */
@ManagedBean(name = "bandImageUploadBean")
@ViewScoped
public class BandImageUploadMB {

    private static final Logger LOGGING = LoggerFactory.getLogger(BandImageUploadMB.class);

    @ManagedProperty(value = "#{bandImageBean}")
    private BandImageMB bandImageMB;

    @ManagedProperty(value = "#{bandBean}")
    private BandMB bandMB;

    @EJB
    private BandImageService bandImageService;

    private InputStream input;
    private String filename;

    public void create(FileUploadEvent event){
        UploadedFile uploadedFile = event.getFile();
        filename = uploadedFile.getFileName();
        try {
            input = uploadedFile.getInputstream();
            LOGGING.info("An Image was uploaded.");
        } catch (IOException e) {
            LOGGING.error("Uploaded file can't put into inputstream!");
        }
    }

    public void upload() {
        if (input == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Image was not uploaded!", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        Path filePath = createPath();
        try {
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            LOGGING.error("Can't save image!");
        }
        saveBandImageToDB(filePath);
        LOGGING.info("Store an image and save entity to database.");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/publicbandprofile.xhtml?faces-redirect=true&id=" + bandMB.getBandVo().getId());
        } catch (IOException e) {
            LOGGING.error("Bad redirect.");
        }
    }

    public Path createPath(){
        Path folder = Paths.get(System.getProperty("jboss.server.data.dir"), "uploadedImage");
        if (!folder.toFile().exists()) {
            if (!folder.toFile().mkdirs()) {
                folder = Paths.get(System.getProperty("jboss.server.data.dir"));
            }
        }
        return Paths.get(folder.toString() + "\\" + filename);
    }

    public void saveBandImageToDB(Path filePath){
        bandImageMB.getBandImageVo().setName(filename);
        bandImageMB.getBandImageVo().setFilename(filePath.toString());
        bandImageMB.getBandImageVo().setBandId(bandMB.getBandVo().getId());
        LOGGING.info(bandImageMB.getBandImageVo().getBandId().toString());
        bandImageService.saveBandImage(bandImageMB.getBandImageVo());
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public BandImageMB getBandImageMB() {
        return bandImageMB;
    }

    public void setBandImageMB(BandImageMB bandImageMB) {
        this.bandImageMB = bandImageMB;
    }
}
