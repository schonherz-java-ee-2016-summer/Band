package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Entity for events.
 */
@Entity
@Table(name = "event")
public class EventEntity extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column
    private String description;

    @Basic
    @Column(nullable = false)
    private LocalDateTime start;

    @Basic
    @Column(nullable = false)
    private LocalDateTime finish;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "bandId", nullable = false)
    private BandEntity band;

    @Basic
    @Column(nullable = false)
    private Long venueId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<EventImageEntity> images;

    public Collection<EventImageEntity> getImages() {
        return images;
    }

    public void setImages(Collection<EventImageEntity> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
