package hu.schonherz.training.band.vo;

import hu.schonherz.training.band.entities.BandEntity;

import java.io.Serializable;

/**
 * @author Armin Veress
 * The Value Object of Demo.
 */
public class DemoVo implements Serializable {

    private BandEntity band;

    private String name;

    private String filename;

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
