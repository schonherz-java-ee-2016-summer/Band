package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.application.FileUploadView;
import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.BandMateMB;
import hu.schonherz.training.band.managedbeans.view.BandMatesMB;
import hu.schonherz.training.band.service.BandMateService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandMateVo;
import hu.schonherz.training.band.vo.BandVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.request.CreateBandMateMB}
 *  ManagedBean for BandMate.
 */
@ManagedBean(name = "createBandMateBean")
@RequestScoped
public class CreateBandMateMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateBandMateMB.class);

    @ManagedProperty(value = "#{bandMateBean}")
    private BandMateMB bandMateMB;

    @ManagedProperty(value = "#{bandMatesBean}")
    private BandMatesMB bandMatesMB;

    public void save(){
        BandMateVo bandMate = new BandMateVo();

        bandMate.setFirstName(bandMateMB.getBandMateVo().getFirstName());
        bandMate.setLastName(bandMateMB.getBandMateVo().getLastName());
        bandMate.setEmail(bandMateMB.getBandMateVo().getEmail());
        bandMate.setProfile(bandMateMB.getBandMateVo().isProfile());

        bandMatesMB.getBandMateVos().add(bandMate);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Save completed: " + bandMateMB.getBandMateVo().getFirstName()
                        + " " + bandMateMB.getBandMateVo().getLastName()));
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

}
