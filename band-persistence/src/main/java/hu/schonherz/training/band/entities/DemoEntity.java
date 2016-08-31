package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * Entity for demos.
 */
@Entity
@Table(name = "demos")
public class DemoEntity extends BaseEntity {

    /**
     * The name of the demo.
     */
    @Basic
    @Column(nullable = false)
    private String name;

    /**
     * The full path of the demo file.
     */
    @Basic
    @Column(nullable = false)
    private String filename;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandId")
    @Column(nullable = false)
    private BandEntity band;

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

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }
}
