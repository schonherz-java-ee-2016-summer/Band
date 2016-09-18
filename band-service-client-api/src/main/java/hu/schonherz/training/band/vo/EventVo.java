package hu.schonherz.training.band.vo;

import java.time.LocalDateTime;

/**
 * @author Armin Veress
 * The Value object of Event.
 */
public class EventVo extends BaseVo {

    private Long bandId;

    private Long venueId;

    private String name;

    private String description;

    private LocalDateTime start;

    private LocalDateTime finish;

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
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

    @Override
    public String toString() {
        return "EventVo{" +
                "id=" + super.getId() +
                "bandId=" + bandId +
                ", venueId=" + venueId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
