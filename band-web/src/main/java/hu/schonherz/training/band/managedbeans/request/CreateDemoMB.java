package hu.schonherz.training.band.managedbeans.request;

import hu.schonherz.training.band.service.DemoService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Armin Veress
 */
@ManagedBean(name = "createDemoBean")
@RequestScoped
public class CreateDemoMB {

    @EJB
    private DemoService demoService;

}
