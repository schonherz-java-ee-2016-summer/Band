package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.util.Collection;


/**
 *  Entity for bands.
 */
@Entity
@Table(name = "band")
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
    private Collection<BandImageEntity> bandImageEntities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventimage")
    private Collection<EventImageEntity> eventsImageEntities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bandmate")
    private Collection<BandMatesEntity> bandMatesEntities;

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

    public void setEvents(Collection<EventEntity> eventEntities) {
        this.events = eventEntities;
    }

    public Collection<BandImageEntity> getBandImageEntities() {
        return bandImageEntities;
    }

    public void setBandImageEntities(Collection<BandImageEntity> bandImageEntities) {
        this.bandImageEntities = bandImageEntities;
    }

    public Collection<EventImageEntity> getEventsImageEntities() {
        return eventsImageEntities;
    }

    public void setEventsImageEntities(Collection<EventImageEntity> eventsImageEntities) {
        this.eventsImageEntities = eventsImageEntities;
    }

    public Collection<BandMatesEntity> getBandMatesEntities() {
        return bandMatesEntities;
    }

    public void setBandMatesEntities(Collection<BandMatesEntity> bandMatesEntities) {
        this.bandMatesEntities = bandMatesEntities;
    }
}
