package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.managedbeans.view.BandsMB}
 */
@ManagedBean(name = "bandsBean")
@ViewScoped
public class BandsMB implements Serializable {

    List<BandVo> bandVos = new ArrayList<>();

    public List<BandVo> getBandVos() {
        return bandVos;
    }

    public void setBandVos(List<BandVo> bandVos) {
        this.bandVos = bandVos;
    }
}
