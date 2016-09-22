package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.EventVo;
import org.primefaces.model.DefaultScheduleEvent;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Armin Veress
 */
public class SchemaMB extends DefaultScheduleEvent {

    private String id;

    private String description;

    private EventVo eventVo;

    public SchemaMB() {
    }

    public SchemaMB(Date object) {
        eventVo = new EventVo();
        eventVo.setStart(LocalDateTime.ofInstant
                (object.toInstant(), ZoneId.systemDefault()));
        eventVo.setFinish(LocalDateTime.ofInstant
                (object.toInstant(), ZoneId.systemDefault()));
    }

    public SchemaMB(String title, Date start, Date end, String description, String id) {
        super(title, start, end);
        this.description = description;
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public EventVo getEventVo() {
        return eventVo;
    }

    public void setEventVo(EventVo eventVo) {
        this.eventVo = eventVo;
    }
}
