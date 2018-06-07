package com.nuc.lg.ibeacon.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "attraction", schema = "ibeacon", catalog = "")
@IdClass(AttractionEntityPK.class)
public class AttractionEntity {
    private String uuid;
    private String major;
    private String minor;
    private String name;
    private String bgPath;
    private String point;
    private Integer ticketId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "bg_path")
    public String getBgPath() {
        return bgPath;
    }

    public void setBgPath(String bgPath) {
        this.bgPath = bgPath;
    }

    @Basic
    @Column(name = "point")
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttractionEntity that = (AttractionEntity) o;
        return Objects.equals(uuid, that.uuid) &&
                Objects.equals(major, that.major) &&
                Objects.equals(minor, that.minor) &&
                Objects.equals(name, that.name) &&
                Objects.equals(bgPath, that.bgPath) &&
                Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, major, minor, name, bgPath, ticketId, point);
    }

    @Override
    public String toString() {
        return "AttractionEntity{" +
                "uuid='" + uuid + '\'' +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", name='" + name + '\'' +
                ", bgPath='" + bgPath + '\'' +
                ", point='" + point + '\'' +
                '}';
    }

    @Basic
    @Column(name = "ticket_id")
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
