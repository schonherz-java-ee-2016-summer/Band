package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 */
@ManagedBean(name = "publicBandProfileBean")
@RequestScoped
public class PublicBandProfileMB {

    private Logger LOG = LoggerFactory.getLogger(PublicBandProfileMB.class);

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @EJB
    private BandService bandService;

    public void onload() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            BandVo bandVo = bandService.getBandById(bandMB.getBandVo().getId());

            bandMB.setBandVo(bandVo);
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
}
