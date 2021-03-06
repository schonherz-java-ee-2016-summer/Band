package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.BandMateMB;
import hu.schonherz.training.band.managedbeans.view.BandMatesMB;
import hu.schonherz.training.band.service.BandMateService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.landing.vo.remote.RemoteUserVo;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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

    @ManagedProperty(value = "#{bandMateBean}")
    private BandMateMB bandMateMB;

    @ManagedProperty(value = "#{bandMatesBean}")
    private BandMatesMB bandMatesMB;

    @ManagedProperty("#{USER}")
    private RemoteUserVo userVo;

    @EJB
    private BandService bandService;

    @EJB
    private BandMateService bandMateService;

    public String doCreate() {
        bandMB.getBandVo().setDisabled(false);
        bandMB.getBandVo().setOwnerid(userVo.getId());
        bandService.createBand(bandMB.getBandVo());

        for (BandMateVo bandMateVo: bandMatesMB.getBandMateVos()) {
            bandMateVo.setBandId(bandService.getBandByName(bandMB.getBandVo().getName()).getId());
            bandMateService.createBandMate(bandMateVo);
        }

        return "profile?faces-redirect=true&id=" + bandService.getBandByName(bandMB.getBandVo().getName()).getId();
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public BandMateMB getBandMateMB() {
        return bandMateMB;
    }

    public void setBandMateMB(BandMateMB bandMateMB) {
        this.bandMateMB = bandMateMB;
    }

    public BandMatesMB getBandMatesMB() {
        return bandMatesMB;
    }

    public void setBandMatesMB(BandMatesMB bandMatesMB) {
        this.bandMatesMB = bandMatesMB;
    }

    public RemoteUserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(RemoteUserVo userVo) {
        this.userVo = userVo;
    }
}
