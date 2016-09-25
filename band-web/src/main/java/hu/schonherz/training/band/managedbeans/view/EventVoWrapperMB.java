package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.managedbeans.wrapper.EventVoWrapper;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Lenovo on 2016.09.21..
 */
@ManagedBean(name = "eventVoWrapperBean")
@ViewScoped
public class EventVoWrapperMB implements Serializable {

    EventVoWrapper event = new EventVoWrapper();

    public EventVoWrapper getEvent() {
        return event;
    }

    public void setEvent(EventVoWrapper event) {
        this.event = event;
    }
}
