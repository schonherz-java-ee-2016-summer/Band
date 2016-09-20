package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.view.BandMB}
 *  ManagedBean for Band.
 */
@ManagedBean(name = "bandBean")
@ViewScoped
public class BandMB implements Serializable {

    private BandVo bandVo = new BandVo();

    private List<BandVo> bands = new ArrayList<>();

    @EJB
    private BandService bandService;

    @PostConstruct
    public void init(){
        bands = (List<BandVo>) bandService.getAllBand();
    }

    public BandVo getBandVo() {
        return bandVo;
    }

    public void setBandVo(BandVo bandVo) {
        this.bandVo = bandVo;
    }

    public List<BandVo> getBands() {
        return bands;
    }

    public void setBands(List<BandVo> bands) {
        this.bands = bands;
    }
}
