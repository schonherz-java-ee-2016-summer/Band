package hu.schonherz.training.band.vo;

/**
  * @author Attila Holhós
  * {@link hu.schonherz.training.band.vo.BandImageVo}
  * Value object for band image.
 */
public class BandImageVo extends BaseVo {

    private Long bandId;

    private String name;

    private String filename;

    private String caption;

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
