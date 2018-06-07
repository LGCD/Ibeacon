package com.nuc.lg.ibeacon.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "souvenir", schema = "ibeacon", catalog = "")
public class SouvenirEntity {
    private int id;
    private String name;
    private String src;
    private String image;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "src")
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SouvenirEntity that = (SouvenirEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(src, that.src) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, src, image);
    }
}
