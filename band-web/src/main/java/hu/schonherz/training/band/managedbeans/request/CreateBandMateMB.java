package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMateMB;
import hu.schonherz.training.band.managedbeans.view.BandMatesMB;
import hu.schonherz.training.band.vo.BandMateVo;
import org.primefaces.context.RequestContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.request.CreateBandMateMB}
 *  ManagedBean for BandMate.
 */
@ManagedBean(name = "createBandMateBean")
@RequestScoped
public class CreateBandMateMB {

    @ManagedProperty(value = "#{bandMateBean}")
    private BandMateMB bandMateMB;

    @ManagedProperty(value = "#{bandMatesBean}")
    private BandMatesMB bandMatesMB;

    public void save(){
        BandMateVo bandMate = new BandMateVo();

        bandMate.setFirstName(bandMateMB.getBandMateVo().getFirstName());
        bandMate.setLastName(bandMateMB.getBandMateVo().getLastName());
        bandMate.setEmail(bandMateMB.getBandMateVo().getEmail());
        bandMate.setInstrument(bandMateMB.getBandMateVo().getInstrument());
        bandMate.setProfile(bandMateMB.getBandMateVo().isProfile());

        bandMatesMB.getBandMateVos().add(bandMate);

        ApplicationContext context = new ClassPathXmlApplicationContext("resourcebundles.xml");
        String message = context.getMessage("band.mate.save.success", null, Locale.getDefault());
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(message + ": " + bandMate.getFirstName()
                        + " " + bandMate.getLastName()));
        bandMateMB.setBandMateVo(new BandMateVo());
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
