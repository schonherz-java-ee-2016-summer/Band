package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * In this class's instance there will be picture, which belong to an event.
 */
@Entity
@Table(name = "eventimage")
public class EventImageEntity extends BaseAssetEntity {

    @Basic
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    @Column(nullable = false)
    private EventEntity event;

    @Basic
    @Column(nullable = false)
    private String caption;

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
