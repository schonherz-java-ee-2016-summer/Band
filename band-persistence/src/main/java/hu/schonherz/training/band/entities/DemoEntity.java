package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * Entity for demos.
 */
@Entity
@Table(name = "demo")
public class DemoEntity extends BaseAssetEntity {

    @ManyToOne
    @JoinColumn(name = "bandId")
    private BandEntity band;

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "band=" + band + super.toString() +
                '}';
    }
}
