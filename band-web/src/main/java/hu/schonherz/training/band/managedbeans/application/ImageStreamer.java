package hu.schonherz.training.band.managedbeans.application;

import hu.schonherz.training.band.service.BandImageService;
import hu.schonherz.training.band.vo.BandImageVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Attila on 2016.09.13..
 */
@ManagedBean(name = "imageStreamerBean")
@ApplicationScoped
public class ImageStreamer {

    @EJB
    private BandImageService bandImageService;

    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("Szia");
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String id = context.getExternalContext().getRequestParameterMap().get("imageId");
            System.out.println(id);
            BandImageVo bandImageVo = bandImageService.getImageById(Long.valueOf(id));
            System.out.println(bandImageVo.toString());
            return new DefaultStreamedContent(
                    new FileInputStream(bandImageVo.getFilename()));
        }
    }

}
