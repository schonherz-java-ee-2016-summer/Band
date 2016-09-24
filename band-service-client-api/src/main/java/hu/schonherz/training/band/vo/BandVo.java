package hu.schonherz.training.band.vo;

import java.util.Collection;

/**
 * @author Norbert Barocsi
 * {@link BandVo}
 *  Value object for band.
 */
public class BandVo extends BaseVo {

    private Long ownerid;
    private String name;
    private String genre;
    private String description;
    private boolean disabled;


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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public String toString() {
        return "BandVo{" +
                "ownerid=" + ownerid +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", disabled=" + disabled +
                '}';
    }
}
