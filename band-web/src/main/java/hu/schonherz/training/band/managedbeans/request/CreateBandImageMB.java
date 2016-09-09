package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.session.ImageManager;
import hu.schonherz.training.band.managedbeans.view.BandImageMB;
import hu.schonherz.training.band.service.BandImageService;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Attila Holhós
 * {@link hu.schonherz.training.band.managedbeans.request.CreateBandImageMB}
 */
@ManagedBean(name = "createBandImageBean")
@ViewScoped
public class CreateBandImageMB {

    private Logger LOG = LoggerFactory.getLogger(CreateBandImageMB.class);

    @ManagedProperty(value = "#{bandImageBean}")
    private BandImageMB bandImageMB;

    @Inject
    private ImageManager imageManager;

    @EJB
    private BandImageService bandImageService;

    private UploadedFile uploadedFile;
    private Path filePath;

    public void upload(FileUploadEvent event) {
        uploadedFile = event.getFile();
        LOG.info("Uploaded File Name Is :: " + uploadedFile.getFileName() + " :: Uploaded File Size :: " + uploadedFile.getSize());

        Path folder = Paths.get(System.getProperty("jboss.server.data.dir"), "upload");
        if (!folder.toFile().exists()) {
            if (!folder.toFile().mkdirs()) {
                folder = Paths.get(System.getProperty("jboss.server.data.dir"));
            }
        }
        filePath = Paths.get(folder.toString() + "\\" + uploadedFile.getFileName());
        LOG.info(filePath.toString());
        try (InputStream input = uploadedFile.getInputstream()) {
            Files.copy(input, filePath, StandardCopyOption.REPLACE_EXISTING);
            OutputStream output = new FileOutputStream(new File(filePath.toString()));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }
            input.close();
            output.flush();
            output.close();
            System.out.println("New file created!");

            imageManager.addUnconfirmedUploadedFile(filePath.toFile());
        } catch (IOException e1) {
            LOG.error("IOException");
        }
    }

    public String create() {
        imageManager.confirmUploadedFile(filePath.toFile());
        bandImageMB.getBandImageVo().setName(uploadedFile.getFileName());
        bandImageMB.getBandImageVo().setFilename(filePath.toString());
        bandImageMB.getBandImageVo().setBandId(1L);
        LOG.info(bandImageMB.getBandImageVo().getBandId().toString());
        bandImageService.saveBandImage(bandImageMB.getBandImageVo());
        return "index";
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public BandImageMB getBandImageMB() {
        return bandImageMB;
    }

    public void setBandImageMB(BandImageMB bandImageMB) {
        this.bandImageMB = bandImageMB;
    }
}
