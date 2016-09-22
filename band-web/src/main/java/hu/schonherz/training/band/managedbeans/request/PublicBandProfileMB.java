package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandImagesMB;
import hu.schonherz.training.band.managedbeans.view.BandMB;

import hu.schonherz.training.band.managedbeans.view.BandMatesMB;
import hu.schonherz.training.band.managedbeans.view.DemosMB;
import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.service.BandMateService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandImageVo;
import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.DemoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 *
 */
@ManagedBean(name = "publicBandProfileBean")
@RequestScoped
public class PublicBandProfileMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicBandProfileMB.class);

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @ManagedProperty("#{scheduleViewMB}")
    private ScheduleViewMB scheduleViewMB;

    @ManagedProperty("#{bandDemosBean}")
    private DemosMB demosMB;

    @ManagedProperty("#{bandMatesBean}")
    private BandMatesMB bandMatesMB;

    @ManagedProperty("#{bandImagesBean}")
    private BandImagesMB bandImagesMB;

    @EJB
    private BandImageService bandImageService;

    @EJB
    private BandService bandService;

    @EJB
    private DemoService demoService;

    @EJB
    private BandMateService bandMateService;

    public void onLoad() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            BandVo bandVo = bandService.getBandById(bandMB.getBandVo().getId());
            bandMB.setBandVo(bandVo);

            List<BandMateVo> bandMateVos = (List<BandMateVo>) bandMateService.getBandMateVosByBand(bandVo);
            bandMatesMB.setBandMateVos(bandMateVos);

            List<BandImageVo> bandImageVos = (List<BandImageVo>) bandImageService.getImagesByBand(bandVo);
            bandImagesMB.setBandImageVos(bandImageVos);

            List<DemoVo> demoVos = (List<DemoVo>) demoService.getDemosByBandId(bandVo);
            demosMB.setDemoVos(demoVos);
        }

        LOGGER.info("onLoad completed.");
    }

    public void editBand(ActionEvent actionEvent) {
        bandService.createBand(bandMB.getBandVo());
        LOGGER.info("Modified band with id {} successfully.", bandMB.getBandVo().getId());
    }

    public void demoDelete(DemoVo demoVo){
        demoService.deleteDemo(demoVo);
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public ScheduleViewMB getScheduleViewMB() {
        return scheduleViewMB;
    }

    public void setScheduleViewMB(ScheduleViewMB scheduleViewMB) {
        this.scheduleViewMB = scheduleViewMB;
    }

    public DemosMB getDemosMB() {
        return demosMB;
    }

    public void setDemosMB(DemosMB demosMB) {
        this.demosMB = demosMB;
    }

    public BandMatesMB getBandMatesMB() {
        return bandMatesMB;
    }

    public void setBandMatesMB(BandMatesMB bandMatesMB) {
        this.bandMatesMB = bandMatesMB;
    }

    public BandImagesMB getBandImagesMB() {
        return bandImagesMB;
    }

    public void setBandImagesMB(BandImagesMB bandImagesMB) {
        this.bandImagesMB = bandImagesMB;
    }
}
