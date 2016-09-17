package hu.schonherz.training.band.managedbeans.wrapper;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.vo.BandImageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Collection;

/**
 * Created by Attila on 2016.09.17..
 */
@ManagedBean(name = "bandImageWrapper")
@RequestScoped
public class BandImageVoWrapper {

    private Logger LOG = LoggerFactory.getLogger(BandImageVoWrapper.class);

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    private Collection<BandImageVo> bandImageVoList;

    @PostConstruct
    public void init(){
        bandImageVoList = bandMB.getBandVo().getBandsImages();
    }

    public Collection<BandImageVo> getBandImageVoList() {
        return bandImageVoList;
    }

    public void setBandImageVoList(Collection<BandImageVo> bandImageVoList) {
        this.bandImageVoList = bandImageVoList;
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }
}
