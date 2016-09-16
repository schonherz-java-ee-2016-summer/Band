package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandImageMB;
import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.service.BandImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.File;

/**
 * Created by Attila on 2016.09.16..
 */
@ManagedBean(name = "editBandImageBean")
public class EditBandImageMB {

    private Logger LOGGER = LoggerFactory.getLogger(EditBandImageMB.class);

    @ManagedProperty("#{bandImageBean}")
    private BandImageMB bandImageMB;

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @EJB
    private BandImageService bandImageService;

    public void startEdit(Long id){
        bandImageMB.setBandImageVo(bandImageService.getImageById(id));
        LOGGER.info("Loading bandimage to edit!");
    }

    public void executeEdit(){
        bandImageService.saveBandImage(bandImageMB.getBandImageVo());
        LOGGER.info("Caption of " + bandImageMB.getBandImageVo().getName() + " was modified");
    }

    public String removeImage(Long id){
        LOGGER.info(bandImageService.getImageById(id).getFilename() + " was deleted!");
        File image = new File((bandImageService.getImageById(id).getFilename()));
        bandImageService.deleteBandImage(bandImageService.getImageById(id));
        image.delete();
        return "/publicbandprofile?faces-redirect=true&id=" + bandMB.getBandVo().getId();
    }

    public BandImageMB getBandImageMB() {
        return bandImageMB;
    }

    public void setBandImageMB(BandImageMB bandImageMB) {
        this.bandImageMB = bandImageMB;
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }
}
