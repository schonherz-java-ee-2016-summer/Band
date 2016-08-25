package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * In this class's instance there will be picture, which belong to an bang.
 */

@Entity
@Table(name = "bandspictures")
public class BandsImage extends BaseEntity{

    @Basic
    private String name;

    @Basic
    private String filename;

    @Basic
    private Long bandId;

    @Basic
    private String caption;

    public BandsImage(String name, String filename, Long bandId, String caption) {
        this.name = name;
        this.filename = filename;
        this.bandId = bandId;
        this.caption = caption;
    }

    public BandsImage() {
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

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
