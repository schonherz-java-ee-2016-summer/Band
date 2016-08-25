package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * In this class's instance there will be picture, which belong to an event.
 */

@Entity
@Table(name = "\"eventspictures\"")
public class EventsImage extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String filename;

    @Basic
    @Column(nullable = false)
    private Long eventId;

    @Basic
    @Column(nullable = false)
    private String caption;

    public EventsImage(String name, String filename, Long eventId, String caption) {
        this.name = name;
        this.filename = filename;
        this.eventId = eventId;
        this.caption = caption;
    }

    public EventsImage(){
    }

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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}