package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Attila on 2016.08.25..
 */

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
