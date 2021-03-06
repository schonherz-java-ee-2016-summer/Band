package hu.schonherz.training.band.managedbeans.application;

import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.vo.BandImageVo;
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
import java.util.Map;

/**
 * @author Attila Holhós
 * {@link hu.schonherz.training.band.managedbeans.application.ImageStreamer}
 * It is needed to display image in gallery of primefaces.
 */
@ManagedBean(name = "imageStreamerBean")
@ApplicationScoped
public class ImageStreamer {

    private static final Logger LOG = LoggerFactory.getLogger(ImageStreamer.class);

    @EJB
    private BandImageService bandImageService;

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("imageId");
            BandImageVo bandImageVo = bandImageService.getImageById(Long.valueOf(id));
            LOG.info("Display " + bandImageVo.getName() + ".");
            return new DefaultStreamedContent(
                    new FileInputStream(bandImageVo.getFilename()));
        }
    }
}
