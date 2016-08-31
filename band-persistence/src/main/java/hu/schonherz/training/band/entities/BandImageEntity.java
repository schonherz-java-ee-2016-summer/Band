package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * In this class's instance there will be picture, which belong to an bang.
 */

@Entity
@Table(name = "bandimage")
public class BandImageEntity extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String filename;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandId")
    @Column(nullable = false)
    private BandEntity band;

    @Basic
    @Column(nullable = false)
    private String caption;

}
