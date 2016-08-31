package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.util.Collection;


/**
 * Created by Mindfield on 2016. 08. 25..
 */
@Entity
@Table(name = "bands")
public class BandEntity extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String genre;

    @Basic
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<EventEntity> events;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bandimage")
    private Collection<BandImageEntity> bandsImages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventimage")
    private Collection<EventImageEntity> eventsImages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "demo")
    private Collection<DemoEntity> demos;

    public Collection<DemoEntity> getDemos() {
        return demos;
    }

    public void setDemos(Collection<DemoEntity> demos) {
        this.demos = demos;
    }

    public BandEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(Collection<EventEntity> events) {
        this.events = events;
    }

    public Collection<BandImageEntity> getBandsImages() {
        return bandsImages;
    }

    public void setBandsImages(Collection<BandImageEntity> bandsImages) {
        this.bandsImages = bandsImages;
    }

    public Collection<EventImageEntity> getEventsImages() {
        return eventsImages;
    }

    public void setEventsImages(Collection<EventImageEntity> eventsImages) {
        this.eventsImages = eventsImages;
    }
}
