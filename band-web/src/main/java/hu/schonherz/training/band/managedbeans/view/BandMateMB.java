package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandMateVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.view.BandMateMB}
 *  ManagedBean for BandMate.
 */
@ManagedBean(name = "bandMateBean")
@ViewScoped
public class BandMateMB implements Serializable {

    private BandMateVo bandMateVo = new BandMateVo();

    public BandMateVo getBandMateVo() {
        return bandMateVo;
    }

    public void setBandMateVo(BandMateVo bandMateVo) {
        this.bandMateVo = bandMateVo;
    }
}
