package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.entities.BandMateEntity}
 *  Entity for band members.
 */
@Entity
@Table(name = "bandmate")
public class BandMateEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "bandId")
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

    @Basic
    @Column(nullable = false)
    private String email;

    @Basic
    @Column(nullable = false)
    private String instrument;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

}
