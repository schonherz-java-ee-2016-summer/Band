package hu.schonherz.training.band.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mindfield on 2016. 08. 25..
 */
@Entity
@Table(name = "bands")
public class BandEntity extends BaseEntity{

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String genre;

    @Basic
    private String description;
    

    public BandEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
