package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;

import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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

    @EJB
    private BandImageService bandImageService;

    @EJB
    private BandService bandService;

    @EJB
    private DemoService demoService;

    public void onLoad() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            BandVo bandVo = bandService.getBandById(bandMB.getBandVo().getId());
            bandMB.setBandVo(bandVo);
        }

        LOGGER.info("onLoad completed.");
    }

    public void editBand(ActionEvent actionEvent) {
        bandService.createBand(bandMB.getBandVo());
        LOGGER.info("Modified band with id {} successfully.", bandMB.getBandVo().getId());
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

}
