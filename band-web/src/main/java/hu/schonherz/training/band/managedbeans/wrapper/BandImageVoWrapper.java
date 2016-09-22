package hu.schonherz.training.band.managedbeans.wrapper;

import hu.schonherz.training.band.managedbeans.view.BandImagesMB;
import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.vo.BandImageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Collection;
import java.util.List;

/**
 * Created by Attila on 2016.09.17..
 */
@ManagedBean(name = "bandImageWrapper")
@RequestScoped
public class BandImageVoWrapper {

    private static final Logger LOG = LoggerFactory.getLogger(BandImageVoWrapper.class);

    @ManagedProperty("#{bandImagesBean}")
    private BandImagesMB bandImagesMB;

    private List<BandImageVo> bandImageVos;

    @PostConstruct
    public void init(){
        bandImageVos = bandImagesMB.getBandImageVos();
    }

    public BandImagesMB getBandImagesMB() {
        return bandImagesMB;
    }

    public void setBandImagesMB(BandImagesMB bandImagesMB) {
        this.bandImagesMB = bandImagesMB;
    }

    public List<BandImageVo> getBandImageVos() {
        return bandImageVos;
    }

    public void setBandImageVos(List<BandImageVo> bandImageVos) {
        this.bandImageVos = bandImageVos;
    }
}
