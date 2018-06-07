package com.nuc.lg.ibeacon.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class IbeaconEntityPK implements Serializable {
    private String uuid;
    private String major;
    private String minor;

    @Column(name = "uuid")
    @Id
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Column(name = "major")
    @Id
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Column(name = "minor")
    @Id
    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IbeaconEntityPK that = (IbeaconEntityPK) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(major, that.major) &&
                Objects.equals(minor, that.minor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, major, minor);
    }
}
