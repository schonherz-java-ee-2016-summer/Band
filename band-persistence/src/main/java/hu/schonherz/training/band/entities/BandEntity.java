package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.util.Collection;


/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.entities.BandEntity}
 * Entity for bands.
 */
@Entity
@Table(name = "band")
public class BandEntity extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private Long userId;

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String genre;

    @Basic
    private String description;

    @Basic
    @Column(nullable = false)
    private boolean disabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<EventEntity> events;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "band")
    private Collection<BandImageEntity> bandsImages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "band")
    private Collection<DemoEntity> demos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<BandMateEntity> bandMates;

    public Collection<DemoEntity> getDemos() {
        return demos;
    }

    public void setDemos(Collection<DemoEntity> demos) {
        this.demos = demos;
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

    public Collection<BandMateEntity> getBandMates() {
        return bandMates;
    }

    public void setBandMates(Collection<BandMateEntity> bandMates) {
        this.bandMates = bandMates;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
