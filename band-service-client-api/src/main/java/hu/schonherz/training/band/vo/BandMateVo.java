package hu.schonherz.training.band.vo;

/**
 * @author Norbert Barocsi
 * {@link hu.schonherz.training.band.vo.BandMateVo}
 *  Value object for band mate.
 */
public class BandMateVo extends BaseVo{

    private Long bandId;

    private String firstName;

    private String lastName;

    private boolean profile;

    private String email;

    private String instrument;

    public BandMateVo() {
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

    @Override
    public String toString() {
        return "BandMateVo{" +
                "bandId=" + bandId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profile=" + profile +
                ", email='" + email + '\'' +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
