package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandImageVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Attila on 2016.09.07..
 */
@ManagedBean(name = "bandImageBean")
@ViewScoped
public class BandImageMB implements Serializable {

    private BandImageVo bandImageVo = new BandImageVo();

    public BandImageVo getBandImageVo() {
        return bandImageVo;
    }

    public void setBandImageVo(BandImageVo bandImageVo) {
        this.bandImageVo = bandImageVo;
    }
}
