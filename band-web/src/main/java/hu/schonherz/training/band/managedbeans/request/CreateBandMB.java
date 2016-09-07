package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.service.BandService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.request.CreateBandMB}
 *  ManagedBean for Band.
 */
@ManagedBean(name = "createBandBean")
@RequestScoped
public class CreateBandMB {

    @ManagedProperty(value = "#{bandBean}")
    private BandMB bandMB;

    @EJB
    private BandService bandService;

    public String doCreate(){
        bandService.createBand(bandMB.getBandVo());
        return "index";
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
