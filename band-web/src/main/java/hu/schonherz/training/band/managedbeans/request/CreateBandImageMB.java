package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandImageMB;
import hu.schonherz.training.band.service.BandImageService;
import org.primefaces.model.UploadedFile;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by Attila on 2016.09.07..
 */
@ManagedBean(name = "createBandImageBean")
@RequestScoped
public class CreateBandImageMB {

    private UploadedFile uploadedFile;

    @ManagedProperty(value = "#{bandImageBean}")
    private BandImageMB bandImageMB;

    @EJB
    private BandImageService bandImageService;

    public String create(){
        System.out.println("Uploaded File Name Is :: "+ uploadedFile.getFileName()+" :: Uploaded File Size :: "+ uploadedFile.getSize());
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
