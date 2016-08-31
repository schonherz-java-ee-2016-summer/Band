package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.util.Collection;


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
    private Collection<BandMember> bandMembers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bandId")
    private Collection<Event> events;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bandId")
    private Collection<BandsImage> bandsImages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    private Collection<EventsImage> eventsImages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bandId")
    private Collection<Demo> demos;

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

    public Collection<BandMember> getBandMembers() {
        return bandMembers;
    }

    public void setBandMembers(Collection<BandMember> bandMembers) {
        this.bandMembers = bandMembers;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Collection<Event> events) {
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

    public Collection<Demo> getDemos() {
        return demos;
    }

    public void setDemos(Collection<Demo> demos) {
        this.demos = demos;
    }
}
