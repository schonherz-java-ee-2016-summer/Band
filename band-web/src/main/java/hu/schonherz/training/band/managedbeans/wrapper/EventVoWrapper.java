package hu.schonherz.training.band.managedbeans.wrapper;

import hu.schonherz.training.band.vo.EventVo;
import org.primefaces.model.DefaultScheduleEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "eventVoWrapper")
@ViewScoped
public class EventVoWrapper extends DefaultScheduleEvent {

    private EventVo eventVo;

    public EventVoWrapper() {
        super("", new Date(), new Date());
        this.eventVo = new EventVo();
        eventVo.setStart(LocalDateTime.now());
        eventVo.setFinish(LocalDateTime.now());
    }

    public EventVoWrapper(EventVo eventVo) {
        this.eventVo = eventVo;
    }

    public EventVoWrapper(String title, Date start, Date end) {
        super(title, start, end);
    }

    public EventVoWrapper(Date object) {
        eventVo = new EventVo();
        eventVo.setStart(LocalDateTime.ofInstant(object.toInstant(), ZoneId.systemDefault()));
        eventVo.setFinish(LocalDateTime.ofInstant(object.toInstant(), ZoneId.systemDefault()));
    }

    public EventVo getEventVo() {
        return eventVo;
    }

    public void setEventVo(EventVo eventVo) {
        this.eventVo = eventVo;
    }

    @Override
    public String getId() {
        return String.valueOf(eventVo.getId());
    }

    @Override
    public String getTitle() {
        return eventVo.getName();
    }

    @Override
    public void setTitle(String title) {
        eventVo.setName(title);
    }

    @Override
    public Date getStartDate() {
        if (eventVo.getStart() == null) {
            return new Date(19890829);
        } else {
            return Date.from(eventVo.getStart().atZone(ZoneId.systemDefault()).toInstant());
        }
    }

    @Override
    public void setStartDate(Date startDate) {
        eventVo.setStart(LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault()));
    }

    @Override
    public Date getEndDate() {
        if (eventVo.getFinish() == null) {
            return new Date(19890829);
        } else {
            return Date.from(eventVo.getFinish().atZone(ZoneId.systemDefault()).toInstant());
        }
    }

    @Override
    public void setEndDate(Date endDate) {
        eventVo.setFinish(LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault()));
    }

    @Override
    public Object getData() {
        return eventVo;
    }

    @Override
    public void setData(Object data) {
        eventVo = (EventVo) data;
    }

    @Override
    public String getDescription() {
        return eventVo.getDescription();
    }

    @Override
    public void setDescription(String description) {
        eventVo.setDescription(description);
    }
}
