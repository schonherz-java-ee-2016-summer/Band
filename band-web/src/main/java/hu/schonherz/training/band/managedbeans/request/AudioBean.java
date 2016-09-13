package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.DemoMB;
import hu.schonherz.training.band.service.BandService;
import hu.schonherz.training.band.service.DemoService;
import hu.schonherz.training.band.vo.BandVo;
import hu.schonherz.training.band.vo.DemoVo;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Lenovo on 2016.09.12..
 */
@ManagedBean(name = "audioBean")
@RequestScoped
public class AudioBean {

    private StreamedContent media;

    public AudioBean() throws FileNotFoundException {

        InputStream stream = new FileInputStream(
                "C:\\Users\\Lenovo\\Documents\\wildfly-10.0.0.Final\\standalone\\data\\band\\" +
                        "Zlad - Elektronik Supersonik.mp3");
        media = new DefaultStreamedContent(stream, "audio/mpeg");
    }

    public StreamedContent getMedia() { return media; }

}
