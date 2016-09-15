package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;

import hu.schonherz.training.band.managedbeans.view.BandMatesMB;
import hu.schonherz.training.band.service.BandMateService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 *
 */
@ManagedBean(name = "publicBandProfileBean")
@RequestScoped
public class PublicBandProfileMB {

    private Logger LOG = LoggerFactory.getLogger(PublicBandProfileMB.class);

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @ManagedProperty("#{bandMatesBean}")
    private BandMatesMB bandMatesMB;

    @EJB
    private BandService bandService;

    @EJB
    private BandMateService bandMateService;

    @EJB
    private DemoService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicBandProfileMB.class);

    public void onload() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            BandVo bandVo = bandService.getBandById(bandMB.getBandVo().getId());
            bandMB.setBandVo(bandVo);

            bandMatesMB.setBandMateVos((List<BandMateVo>) bandMateService.getBandMateVosByBand(bandVo));
        }

        LOG.info("onLoad completed.");
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public BandService getBandService() {
        return bandService;
    }

    public void setBandService(BandService bandService) {
        this.bandService = bandService;
    }

    public BandMatesMB getBandMatesMB() {
        return bandMatesMB;
    }

    public void setBandMatesMB(BandMatesMB bandMatesMB) {
        this.bandMatesMB = bandMatesMB;
    }

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

}
