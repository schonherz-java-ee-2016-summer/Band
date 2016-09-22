package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.BandImageVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 09. 22..
 */
@ManagedBean(name = "bandImagesBean")
@ViewScoped
public class BandImagesMB implements Serializable {

    List<BandImageVo> bandImageVos = new ArrayList<>();

    public List<BandImageVo> getBandImageVos() {
        return bandImageVos;
    }

    public void setBandImageVos(List<BandImageVo> bandImageVos) {
        this.bandImageVos = bandImageVos;
    }
}
