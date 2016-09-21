package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.BandMB;
import hu.schonherz.training.band.managedbeans.view.EventMB;
import hu.schonherz.training.band.managedbeans.view.SchemaMB;
import hu.schonherz.training.band.service.EventService;
import hu.schonherz.training.band.vo.EventVo;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "scheduleViewMB")
@ViewScoped
public class ScheduleViewMB implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleViewMB.class);

    private ScheduleModel eventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    @ManagedProperty("#{eventBean}")
    private EventMB eventMB;

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @EJB
    private EventService eventService;

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        Collection<EventVo> eventVos = eventService.getEventsByBand(bandMB.getBandVo());
        for (EventVo i : eventVos) {
            eventModel.addEvent(new SchemaMB(
                    i.getName(),
                    Date.from(i.getStart().atZone(ZoneId.systemDefault()).toInstant()),
                    Date.from(i.getFinish().atZone(ZoneId.systemDefault()).toInstant()),
                    i.getDescription()));
        }
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }
        
        EventVo eventVo = EventVoMapper(event);
        eventVo.setBandId(bandMB.getBandVo().getId());
        LOGGER.info(String.valueOf(eventVo));
        eventService.createEvent(eventVo);
        event = new DefaultScheduleEvent();
    }

    public static EventVo EventVoMapper(ScheduleEvent event){
        EventVo eventVo = new EventVo();
        eventVo.setName(event.getTitle());
        eventVo.setStart(LocalDateTime.ofInstant
                (event.getStartDate().toInstant(), ZoneId.systemDefault()));
        eventVo.setFinish(LocalDateTime.ofInstant
                (event.getEndDate().toInstant(), ZoneId.systemDefault()));
        eventVo.setDescription(event.getDescription());
        return  eventVo;
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public EventMB getEventMB() {
        return eventMB;
    }

    public void setEventMB(EventMB eventMB) {
        this.eventMB = eventMB;
    }


    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }
}
