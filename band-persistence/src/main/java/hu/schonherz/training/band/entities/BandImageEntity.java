package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * In this class's instance there will be picture, which belong to an bang.
 */

@Entity
@Table(name = "bandimage")
public class BandImageEntity extends ResourceEntity {

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandId")
    @Column(nullable = false)
    private BandEntity band;

    @Basic
    @Column(nullable = false)
    private String caption;

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
