package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Lenovo on 2016.08.25..
 */
@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String description;

    @Basic
    @Column(nullable = false)
    private LocalDateTime start;

    @Basic
    @Column(nullable = false)
    private LocalDateTime finish;

    @Basic
    @Column(nullable = false)
    private int bandId;

    @Basic
    @Column(nullable = false)
    private int venueId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId", nullable = false)
    private Collection<EventsImage> images;

    public Collection<EventsImage> getImages() {
        return images;
    }

    public void setImages(Collection<EventsImage> images) {
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

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
}
