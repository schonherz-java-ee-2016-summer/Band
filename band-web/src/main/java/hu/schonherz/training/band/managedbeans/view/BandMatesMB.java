package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandMateVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Norbert Barocsi
 *  {@link hu.schonherz.training.band.managedbeans.view.BandMatesMB}
 *  ManagedBean for BandMates.
 */
@ManagedBean(name = "bandMatesBean")
@ViewScoped
public class BandMatesMB implements Serializable {

    private List<BandMateVo> bandMateVos = new ArrayList<>();

    public List<BandMateVo> getBandMateVos() {
        return bandMateVos;
    }

    public void setBandMateVos(List<BandMateVo> bandMateVos) {
        this.bandMateVos = bandMateVos;
    }
}
