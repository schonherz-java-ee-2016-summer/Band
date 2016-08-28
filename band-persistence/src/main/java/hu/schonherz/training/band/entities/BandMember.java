package hu.schonherz.training.band.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Mindfield on 2016. 08. 28..
 */
@Entity
@Table(name = "bandmates")
public class BandMember extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private Long bandId;

    @Basic
    @Column(nullable = false)
    private String firstName;

    @Basic
    @Column(nullable = false)
    private String lastName;

    @Basic
    @Column(nullable = false)
    private String profile;

    public BandMember() {
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
