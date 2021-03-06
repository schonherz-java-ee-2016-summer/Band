package hu.schonherz.training.band.vo;

/**
 * @author Armin Veress
 * The Value Object of Demo.
 */
public class DemoVo extends BaseVo {

    private Long bandId;

    private String name;

    private String filename;

    private String fullPath;

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

    public String getFullPath() {
        return this.filename+"\\"+this.name;
    }

    @Override
    public String toString() {
        return "DemoVo{" +
                "bandId=" + bandId +
                ", name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
