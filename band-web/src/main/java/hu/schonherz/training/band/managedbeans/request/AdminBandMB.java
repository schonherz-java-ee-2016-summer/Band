package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.UserOnPage;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.managedbeans.request.AdminBandMB}
 */
@ManagedBean(name = "adminBandBean")
@RequestScoped
public class AdminBandMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBandMB.class);

    @ManagedProperty("#{userOnPageBean}")
    private UserOnPage userOnPage;

    @EJB
    private BandService bandService;

    public void onLoad() {
        if (userOnPage.getAdmin()) {
            LOGGER.info("Admin page onloaded.");
        } else {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                LOGGER.info("Somebody want to watch admin page, but he hasn't got permission to it!");
                ec.redirect(ec.getRequestContextPath() + "/error.xhtml");
            } catch (IOException e) {
                LOGGER.error("Bad redirect.");
            }
        }
    }

    public void blockingBand(BandVo bandVo) {
        bandVo.setDisabled(!bandVo.isDisabled());
        bandService.updateDisabledAttribute(bandVo);
        LOGGER.info(bandVo.getName() + " is " + bandVo.isDisabled());
    }

    public UserOnPage getUserOnPage() {
        return userOnPage;
    }

    public void setUserOnPage(UserOnPage userOnPage) {
        this.userOnPage = userOnPage;
    }
}
