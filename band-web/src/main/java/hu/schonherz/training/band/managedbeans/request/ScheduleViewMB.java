package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.*;
import hu.schonherz.training.band.managedbeans.wrapper.EventVoWrapper;
import hu.schonherz.training.band.service.EventService;
import hu.schonherz.training.band.vo.EventVo;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
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

    @ManagedProperty("#{bandBean}")
    private BandMB bandMB;

    @ManagedProperty(value = "#{eventVoWrapper}")
    private EventVoWrapper event;

    @ManagedProperty(value = "#{scheduleBean}")
    private ScheduleMB schedule;

    @EJB
    private EventService eventService;

    @PostConstruct
    public void init() {
        LOGGER.info("Initializing calendar view...");
        schedule.setEventModel(new DefaultScheduleModel());

        Collection<EventVo> eventVos = eventService.getEventsByBand(bandMB.getBandVo());
        for (EventVo i : eventVos) {
            schedule.getEventModel().addEvent(new EventVoWrapper(
                    i.getName(),
                    Date.from(i.getStart().atZone(ZoneId.systemDefault()).toInstant()),
                    Date.from(i.getFinish().atZone(ZoneId.systemDefault()).toInstant())));
        }
    }

    public void addEvent(ActionEvent actionEvent) {
        LOGGER.info("Adding or updating event...");
        if (event.getEventVo().getId() == null) {
            schedule.getEventModel().addEvent(event);
        } else {
            schedule.getEventModel().updateEvent(event);
        }

        eventService.createEvent(eventVoMapper(event));
    }

    public EventVo eventVoMapper(ScheduleEvent event) {
        LOGGER.info("Mapping Scheduled Event with name {} and description {}...", event.getTitle(), event.getDescription());
        EventVo eventVo = new EventVo();

        eventVo.setBandId(bandMB.getBandVo().getId());
        eventVo.setName(event.getTitle());
        eventVo.setStart(LocalDateTime.ofInstant
                (event.getStartDate().toInstant(), ZoneId.systemDefault()));
        eventVo.setFinish(LocalDateTime.ofInstant
                (event.getEndDate().toInstant(), ZoneId.systemDefault()));
        eventVo.setDescription(event.getDescription());
        eventVo.setVenueId(1L);

        return eventVo;
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new EventVoWrapper((Date) selectEvent.getObject());
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (EventVoWrapper) selectEvent.getObject();
    }

    public BandMB getBandMB() {
        return bandMB;
    }

    public void setBandMB(BandMB bandMB) {
        this.bandMB = bandMB;
    }

    public EventVoWrapper getEvent() {
        return event;
    }

    public void setEvent(EventVoWrapper event) {
        this.event = event;
    }

    public ScheduleMB getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleMB schedule) {
        this.schedule = schedule;
    }
}
