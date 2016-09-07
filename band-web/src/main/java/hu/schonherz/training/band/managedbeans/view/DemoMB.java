package hu.schonherz.training.band.managedbeans.view;

import hu.schonherz.training.band.vo.DemoVo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "demoBean")
@ViewScoped
public class DemoMB implements Serializable {

    private DemoVo demoVo = new DemoVo();

    public DemoVo getDemoVo() {
        return demoVo;
    }

    public void setDemoVo(DemoVo demoVo) {
        this.demoVo = demoVo;
    }
}
