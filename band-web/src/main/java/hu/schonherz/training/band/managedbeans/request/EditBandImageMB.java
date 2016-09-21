package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandImageMB;
import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.wrapper.BandImageVoWrapper;
import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.vo.BandImageVo;
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

    @ManagedProperty("#{bandImageWrapper}")
    private BandImageVoWrapper bandImageVoWrapper;

    @EJB
    private BandImageService bandImageService;

    public String executeEdit(Long id){
        BandImageVo bandImageVo = null;
        for (BandImageVo bandImage : bandImageVoWrapper.getBandImageVoList()){
            if (id == bandImage.getId()){
                bandImageVo = bandImage;
                break;
            }
        }
        bandImageVo.setBandId(bandMB.getBandVo().getId());
        bandImageService.saveBandImage(bandImageVo);
        LOGGER.info("Caption of " + bandImageVo.getName() + " was modified");
        return "/profile?faces-redirect=true&id=" + bandMB.getBandVo().getId();
    }

    public String removeImage(Long id){
        LOGGER.info(bandImageService.getImageById(id).getFilename() + " was deleted!");
        File image = new File((bandImageService.getImageById(id).getFilename()));
        bandImageService.deleteBandImage(bandImageService.getImageById(id));
        image.delete();
        return "/profile?faces-redirect=true&id=" + bandMB.getBandVo().getId();
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

    public BandImageVoWrapper getBandImageVoWrapper() {
        return bandImageVoWrapper;
    }

    public void setBandImageVoWrapper(BandImageVoWrapper bandImageVoWrapper) {
        this.bandImageVoWrapper = bandImageVoWrapper;
    }
}
