package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;

import hu.schonherz.training.band.managedbeans.view.UserOnPage;
import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.landing.vo.RoleVo;
import hu.schonherz.training.landing.vo.UserVo;
import hu.schonherz.training.landing.vo.remote.RemoteRoleVo;
import hu.schonherz.training.landing.vo.remote.RemoteUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 */
@ManagedBean(name = "publicBandProfileBean")
@RequestScoped
public class PublicBandProfileMB {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicBandProfileMB.class);

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @ManagedProperty("#{scheduleViewMB}")
    private ScheduleViewMB scheduleViewMB;

    @ManagedProperty("#{USER}")
    private RemoteUserVo userVo;

    @ManagedProperty("#{userOnPageBean}")
    private UserOnPage userOnPage;

    @EJB
    private BandImageService bandImageService;

    @EJB
    private BandService bandService;

    @EJB
    private DemoService demoService;

    public void onLoad() {
        BandVo bandVo;
        LOGGER.info(userVo.getId().toString());
        checkAdminRole();
        if (bandMB.getBandVo().getId() != null) {
            bandVo = bandService.getBandById(bandMB.getBandVo().getId());
        } else {
            bandVo = bandService.getBandbyUserId(userVo.getId());
        }
        bandMB.setBandVo(bandVo);
        LOGGER.info("onLoad completed.");
    }

    public void checkAdminRole(){
        for (RemoteRoleVo role: userVo.getRoles()){
            if ("ADMIN".equals(role.getName())){
                userOnPage.setAdmin(Boolean.TRUE);
                LOGGER.info("An admin is on page!");
            }
        }
    }

    public void editBand(ActionEvent actionEvent) {
        bandService.createBand(bandMB.getBandVo());
        LOGGER.info("Modified band with id {} successfully.", bandMB.getBandVo().getId());
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public ScheduleViewMB getScheduleViewMB() {
        return scheduleViewMB;
    }

    public void setScheduleViewMB(ScheduleViewMB scheduleViewMB) {
        this.scheduleViewMB = scheduleViewMB;
    }

    public RemoteUserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(RemoteUserVo userVo) {
        this.userVo = userVo;
    }

    public UserOnPage getUserOnPage() {
        return userOnPage;
    }

    public void setUserOnPage(UserOnPage userOnPage) {
        this.userOnPage = userOnPage;
    }
}
