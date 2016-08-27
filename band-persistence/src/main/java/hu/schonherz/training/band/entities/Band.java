package hu.schonherz.training.band.entities;

import javax.persistence.*;


/**
 * Created by Mindfield on 2016. 08. 25..
 */
@Entity
@Table(name = "bands")
public class Band extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String genre;

    @Basic
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bandId")
    private Collection<EventEntity> events;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bandId")
    private Collection<BandsImage> bandsImages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    private Collection<EventsImage> eventsImages;

    public Band() {
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

    public Collection<BandsImage> getBandsImages() {
        return bandsImages;
    }

    public void setBandsImages(Collection<BandsImage> bandsImages) {
        this.bandsImages = bandsImages;
    }

    public Collection<EventsImage> getEventsImages() {
        return eventsImages;
    }

    public void setEventsImages(Collection<EventsImage> eventsImages) {
        this.eventsImages = eventsImages;
    }
}
