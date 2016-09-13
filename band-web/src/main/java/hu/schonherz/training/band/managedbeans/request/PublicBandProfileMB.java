package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.DemoMB;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.vo.DemoVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 */
@ManagedBean(name = "publicBandProfileBean")
@ViewScoped
public class PublicBandProfileMB {

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    /*@ManagedProperty("#{demoBean}")
    private DemoMB demoMB;*/

    @EJB
    private BandService bandService;

    @EJB
    private DemoService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicBandProfileMB.class);

    public void onload() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            BandVo bandVo = bandService.getBandById(bandMB.getBandVo().getId());

            bandMB.setBandVo(bandVo);
        }
    }

    public StreamedContent getDemo() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();

        } else {
            String demoId = context.getExternalContext().getRequestParameterMap().get("demoId");
            LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + demoId);

            DemoVo demo = demoService.getDemoById(1L);
            LOGGER.info("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" + demo.toString());

            return new DefaultStreamedContent(new FileInputStream(Paths.get(demo.getFullPath()).toFile()),
                    "audio/mpeg", demo.getName());
        }
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public BandService getBandService() {
        return bandService;
    }

    public void setBandService(BandService bandService) {
        this.bandService = bandService;
    }

    /*public DemoMB getDemoMB() {
        return demoMB;
    }

    public void setDemoMB(DemoMB demoMB) {
        this.demoMB = demoMB;
    }*/

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }
}
