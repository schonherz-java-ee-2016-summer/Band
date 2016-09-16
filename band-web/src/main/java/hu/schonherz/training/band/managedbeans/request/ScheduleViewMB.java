package hu.schonherz.training.band.managedbeans.request;


import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import hu.schonherz.training.band.managedbeans.view.EventMB;
import hu.schonherz.training.band.service.EventService;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "scheduleViewMB")
@RequestScoped
public class ScheduleViewMB implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleViewMB.class);

    private ScheduleModel eventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    @ManagedProperty("#{eventBean}")
    private EventMB eventMB;

    @EJB
    private EventService eventService;

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
    }

    public void addEvent(ActionEvent actionEvent) {
        LOGGER.info("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        eventService.createEvent(eventMB.getEventVo());
        LOGGER.info(eventMB.getEventVo().toString());
        //event = new DefaultScheduleEvent();
    }


    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
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

    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
