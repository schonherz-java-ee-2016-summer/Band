package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 */
@ManagedBean(name = "bandBean")
@ViewScoped
public class BandMB {

    private BandVo bandVo = new BandVo();

    public BandVo getBandVo() {
        return bandVo;
    }

    public void setBandVo(BandVo bandVo) {
        this.bandVo = bandVo;
    }
}
