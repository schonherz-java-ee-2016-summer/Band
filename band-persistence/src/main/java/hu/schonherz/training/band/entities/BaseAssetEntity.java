package hu.schonherz.training.band.entities;

import javax.persistence.*;

/**
 * @author Attila on 2016.09.01.
 * We have some fields, which are the same in resource class (like in picture, demo).
 * In this class we stress these field to a higher level of inheritance.
 */
@MappedSuperclass
public class BaseAssetEntity extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String filename;

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

    @Override
    public String toString() {
        return "BaseAssetEntity{" +
                "name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
