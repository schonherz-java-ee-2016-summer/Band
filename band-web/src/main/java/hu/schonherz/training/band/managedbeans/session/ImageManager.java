package hu.schonherz.training.band.managedbeans.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.faces.bean.SessionScoped;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Attila Holhós
 */
@Model
@SessionScoped
public class ImageManager {

    private Logger LOG = LoggerFactory.getLogger(ImageManager.class);

    private List<File> unconfirmedUploadedFiles;

    @PostConstruct
    public void init(){
        unconfirmedUploadedFiles = new ArrayList<File>();
    }

    public void addUnconfirmedUploadedFile(File unconfirmedUploadedFile) {
        unconfirmedUploadedFiles.add(unconfirmedUploadedFile);
        LOG.info("Add a picture");
    }

    public void confirmUploadedFile(File confirmedUploadedFile) {
        LOG.info(confirmedUploadedFile.toString());
        unconfirmedUploadedFiles.remove(confirmedUploadedFile);
        LOG.info("Picture confirmed");
    }

    @PreDestroy
    public void destroy() {
        for (File unconfirmedUploadedFile : unconfirmedUploadedFiles) {
            unconfirmedUploadedFile.delete();
        }
    }

}

