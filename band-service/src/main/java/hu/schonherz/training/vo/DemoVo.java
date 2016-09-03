package hu.schonherz.training.vo;

import java.io.Serializable;

/**
 * Created by Lenovo on 2016.09.03..
 */
public class DemoVo implements Serializable {

    private Long bandId;

    private String name;

    private String filename;

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
}
