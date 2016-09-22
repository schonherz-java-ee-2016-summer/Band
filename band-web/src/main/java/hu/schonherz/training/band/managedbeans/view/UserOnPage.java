package hu.schonherz.training.band.managedbeans.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * @author Attila Holhós
 * {@link UserOnPage}
 * This managedBean handle the users properties (like he or she is an admin or not)
 */
@ManagedBean(name = "userOnPageBean")
@ViewScoped
public class UserOnPage implements Serializable {

    private Boolean isAdmin = Boolean.FALSE;
    private Boolean isBandOwner = Boolean.FALSE;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getBandOwner() {
        return isBandOwner;
    }

    public void setBandOwner(Boolean bandOwner) {
        isBandOwner = bandOwner;
    }
}
