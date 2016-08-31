package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Lenovo on 2016.08.25..
 */
@Entity
@Table(name = "event")
public class EventEntity extends BaseEntity {

    /**
     * The name of the event.
     */
    @Basic
    @Column(nullable = false)
    private String name;

    /**
     * A short description of the event.
     */
    @Basic
    @Column(nullable = false)
    private String description;

    /**
     * The time the event starts.
     */
    @Basic
    @Column(nullable = false)
    private LocalDateTime start;

    /**
     * The time the event finishes.
     */
    @Basic
    @Column(nullable = false)
    private LocalDateTime finish;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandId")
    @Column(nullable = false)
    private BandEntity band;

    @Basic
    @Column(nullable = false)
    private Long venueId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventimage")
    private Collection<EventImageEntity> images;


}
