package hu.schonherz.training.band.managedbeans.view;

import org.primefaces.model.DefaultScheduleEvent;

import java.util.Date;

/**
 * @author Armin Veress
 */
public class SchemaMB extends DefaultScheduleEvent {

    private String description;

    public SchemaMB(String title, Date start, Date end, String description) {
        super(title, start, end);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
