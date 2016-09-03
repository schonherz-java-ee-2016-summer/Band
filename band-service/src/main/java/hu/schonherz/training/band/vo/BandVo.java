package hu.schonherz.training.band.vo;

/**
 *  Value object for band.
 */
public class BandVo extends BaseVo{

    private String name;

    private String genre;

    private String description;

    private Collection<EventVo> events;

    private Collection<BandImageVo> bandsImages;

    private Collection<DemoVo> demos;

    private Collection<BandMateVo> bandMates;

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

    public Collection<EventVo> getEvents() {
        return events;
    }

    public void setEvents(Collection<EventVo> events) {
        this.events = events;
    }

    public Collection<BandImageVo> getBandsImages() {
        return bandsImages;
    }

    public void setBandsImages(Collection<BandImageVo> bandsImages) {
        this.bandsImages = bandsImages;
    }

    public Collection<DemoVo> getDemos() {
        return demos;
    }

    public void setDemos(Collection<DemoVo> demos) {
        this.demos = demos;
    }

    public Collection<BandMateVo> getBandMates() {
        return bandMates;
    }

    public void setBandMates(Collection<BandMateVo> bandMates) {
        this.bandMates = bandMates;
    }
}
