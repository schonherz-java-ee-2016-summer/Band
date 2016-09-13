package hu.schonherz.training.band.managedbeans.application;

import hu.schonherz.training.band.managedbeans.request.PublicBandProfileMB;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.DemoVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Lenovo on 2016.09.13..
 */
@ManagedBean(name = "audioStream")
@ApplicationScoped
public class AudioStream {

    private static final Logger LOGGER = LoggerFactory.getLogger(AudioStream.class);

    @EJB
    private DemoService demoService;

    public StreamedContent getDemo() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();

        } else {
            String demoId = context.getExternalContext().getRequestParameterMap().get("demoId");
            LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + demoId);

            DemoVo demo = demoService.getDemoById(Long.valueOf(demoId));
            LOGGER.info("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" + demo.toString());

            return new DefaultStreamedContent(new FileInputStream(Paths.get(demo.getFullPath()).toFile()),
                    "audio/mpeg", demo.getName());

        }
    }
}
