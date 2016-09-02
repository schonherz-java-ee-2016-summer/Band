package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 *  Entity for band members.
 */
@Entity
@Table(name = "bandmate")
public class BandMateEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bandId", nullable = false)
    private BandEntity band;

    @Basic
    @Column(nullable = false)
    private String firstName;

    @Basic
    @Column(nullable = false)
    private String lastName;

    @Basic
    @Column(nullable = false)
    private boolean profile;

    public BandEntity getBand() {
        return band;
    }

    public void setBand(BandEntity band) {
        this.band = band;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isProfile() {
        return profile;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }
}
