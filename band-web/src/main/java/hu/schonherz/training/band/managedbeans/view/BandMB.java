package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 *
 */
@ManagedBean(name = "bandBean")
@ViewScoped
public class BandMB implements Serializable {

    private BandVo bandVo = new BandVo();

    public BandVo getBandVo() {
        return bandVo;
    }

    public void setBandVo(BandVo bandVo) {
        this.bandVo = bandVo;
    }
}
