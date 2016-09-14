package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.service.BandImageService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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

    @EJB
    private BandImageService bandImageService;

    private InputStream input;
    private String filename;

    public void upload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        filename = uploadedFile.getFileName();
        try {
            input = uploadedFile.getInputstream();
            LOGGING.info("An Image was uploaded.");
        } catch (IOException e) {
            LOGGING.error("IOException");
        }
    }

    public String create() {
        if (input == null){
            FacesContext saveContext = FacesContext.getCurrentInstance();
            saveContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload an image!", null));
            return "createbandimage";
        } else {
            Path filePath = createPath();
            try {
                Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                LOGGING.error("IOException");
            }
            saveBandImageToDB(filePath);
            LOGGING.info("Store an image and save entity to database.");
            return "index";
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
        bandImageMB.getBandImageVo().setBandId(1L);
        LOGGING.info(bandImageMB.getBandImageVo().getBandId().toString());
        bandImageService.saveBandImage(bandImageMB.getBandImageVo());
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BandImageMB getBandImageMB() {
        return bandImageMB;
    }

    public void setBandImageMB(BandImageMB bandImageMB) {
        this.bandImageMB = bandImageMB;
    }
}
