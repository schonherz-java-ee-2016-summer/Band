package hu.schonherz.training.band.managedbeans.view;

import org.primefaces.model.ScheduleModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "scheduleBean")
@ViewScoped
public class ScheduleMB implements Serializable {

    private ScheduleModel eventModel;

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }
}
