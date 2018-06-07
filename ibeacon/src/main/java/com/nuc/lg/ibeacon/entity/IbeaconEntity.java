package com.nuc.lg.ibeacon.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ibeacon", schema = "ibeacon", catalog = "")
@IdClass(IbeaconEntityPK.class)
public class IbeaconEntity {
    private String uuid;
    private String major;
    private String minor;
    private int type;
    private String name;
    private String imagePath;
    private String src;

    @Id
    @Column(name = "uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Id
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Id
    @Column(name = "minor")
    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IbeaconEntity that = (IbeaconEntity) o;
        return type == that.type &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(major, that.major) &&
                Objects.equals(minor, that.minor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, major, minor, type);
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
    @Column(name = "image_path")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "IbeaconEntity{" +
                "uuid='" + uuid + '\'' +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", src='" + src + '\'' +
                '}';
    }

    @Basic
    @Column(name = "src")
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
