package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.DemoVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 09. 21..
 */
@ManagedBean(name = "bandDemosBean")
@ViewScoped
public class DemosMB implements Serializable {

    List<DemoVo> demoVos = new ArrayList<>();

    public List<DemoVo> getDemoVos() {
        return demoVos;
    }

    public void setDemoVos(List<DemoVo> demoVos) {
        this.demoVos = demoVos;
    }
}
