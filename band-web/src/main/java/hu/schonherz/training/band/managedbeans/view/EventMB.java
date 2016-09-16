package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.EventVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "eventBean")
@ViewScoped
public class EventMB implements Serializable {

    private EventVo eventVo = new EventVo();

    public EventVo getEventVo() {
        return eventVo;
    }

    public void setEventVo(EventVo eventVo) {
        this.eventVo = eventVo;
    }
}
