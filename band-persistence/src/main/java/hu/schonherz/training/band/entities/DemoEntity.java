package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * Entity for demos.
 */
@Entity
@Table(name = "demo")
public class DemoEntity extends BaseAssetEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandid", nullable = false)
    private BandEntity band;

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }
}
