package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.service.BandImageService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Attila Holhós
 * {@link CreateBandImageMB}
 */
@ManagedBean(name = "createBandImageBean")
@ViewScoped
public class CreateBandImageMB {

    private Logger LOG = LoggerFactory.getLogger(CreateBandImageMB.class);

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
        } catch (IOException e) {
            LOG.error("IOException");
        }
    }

    public String create() {
        Path filePath = createPath();
        storeImage(filePath);
        bandImageMB.getBandImageVo().setName(filename);
        bandImageMB.getBandImageVo().setFilename(filePath.toString());
        bandImageMB.getBandImageVo().setBandId(1L);
        LOG.info(bandImageMB.getBandImageVo().getBandId().toString());
        bandImageService.saveBandImage(bandImageMB.getBandImageVo());
        return "index";
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

    public void storeImage(Path filePath){
        try {
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
        } catch (IOException e1) {
            LOG.error("IOException");
        }
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
