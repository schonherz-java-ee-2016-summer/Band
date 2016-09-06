package hu.schonherz.training.band.vo;

import java.io.Serializable;

/**
 * @author Norbert Barocsi
 * {@link BaseVo}
 * Value object for base.
 */
public class BaseVo implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
