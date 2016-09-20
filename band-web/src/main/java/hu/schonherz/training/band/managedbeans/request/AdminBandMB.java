package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandsMB;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.managedbeans.request.AdminBandMB}
 */
@ManagedBean(name = "adminBandBean")
@RequestScoped
public class AdminBandMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBandMB.class);

    @EJB
    private BandService bandService;

    public void blockingBand(BandVo bandVo){
        bandVo.setDisabled(!bandVo.isDisabled());
        bandService.updateDisabledAttribute(bandVo);
        LOGGER.info(bandVo.getName() + " is " + bandVo.isDisabled());
    }

}
