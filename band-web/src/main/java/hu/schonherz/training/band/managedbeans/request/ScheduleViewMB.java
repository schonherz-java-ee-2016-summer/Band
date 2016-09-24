package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.managedbeans.view.*;
import hu.schonherz.training.band.managedbeans.wrapper.EventVoWrapper;
import hu.schonherz.training.band.service.EventService;
import hu.schonherz.training.band.vo.EventVo;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
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
        schedule.setEventModel(new DefaultScheduleModel());

        Collection<EventVo> eventVos = eventService.getEventsByBand(bandMB.getBandVo());
        for (EventVo i : eventVos) {
            schedule.getEventModel().addEvent(new EventVoWrapper(i));
        }
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getEventVo().getId() == null) {
            schedule.getEventModel().addEvent(event);
        } else {
            schedule.getEventModel().updateEvent(event);
        }

        event.getEventVo().setBandId(bandMB.getBandVo().getId());
        event.getEventVo().setVenueId(1L);
        eventService.createEvent(event.getEventVo());
        init();
    }

    public void deleteEvent(ActionEvent actionEvent) {
        Collection<EventVo> eventVos = eventService.getEventsByBand(bandMB.getBandVo());
        for (EventVo i : eventVos) {
            if (event.getEventVo().getId().equals(i.getId())) {
                eventService.deleteVo(event.getEventVo());
            }
        }
        schedule.getEventModel().deleteEvent(event);
        init();
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
