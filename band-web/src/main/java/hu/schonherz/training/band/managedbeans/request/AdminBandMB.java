package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandsMB;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.managedbeans.request.AdminBandMB}
 */
@ManagedBean(name = "adminBandBean")
@RequestScoped
public class AdminBandMB {

    @ManagedProperty(value = "#{bandsBean}")
    private BandsMB bandsMB;

    private BandVo selectedBand;

    @EJB
    private BandService bandService;

    public void listBand(){
        if (!FacesContext.getCurrentInstance().isPostback()) {
            bandsMB.setBandVos((List<BandVo>) bandService.getAllBand());
        }
    }

    public String blockingBand(){
        selectedBand.setDisabled(!selectedBand.isDisabled());
        bandService.updateDisabledAttribute(selectedBand);
        return "admin";
    }

    public BandsMB getBandsMB() {
        return bandsMB;
    }

    public void setBandsMB(BandsMB bandsMB) {
        this.bandsMB = bandsMB;
    }

    public BandVo getSelectedBand() {
        return selectedBand;
    }

    public void setSelectedBand(BandVo selectedBand) {
        this.selectedBand = selectedBand;
    }
}
