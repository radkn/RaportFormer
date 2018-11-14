package org.refrap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="zone")
public class Zone {
    @Id
    private long id;

    private String scene_id;
    private String zoneTitle;
    private String uid;
    private Timestamp datetime_start;
    private Timestamp datetime_end;
    private int datetime_delay;
    private int type;
    private Timestamp time_stamp;
    private boolean transmitted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }

    public String getZoneTitle() {
        return zoneTitle;
    }

    public void setZoneTitle(String zoneTitle) {
        this.zoneTitle = zoneTitle;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getDatetime_start() {
        return datetime_start;
    }

    public void setDatetime_start(Timestamp datetime_start) {
        this.datetime_start = datetime_start;
    }

    public Timestamp getDatetime_end() {
        return datetime_end;
    }

    public void setDatetime_end(Timestamp datetime_end) {
        this.datetime_end = datetime_end;
    }

    public int getDatetime_delay() {
        return datetime_delay;
    }

    public void setDatetime_delay(int datetime_delay) {
        this.datetime_delay = datetime_delay;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }

    public boolean isTransmitted() {
        return transmitted;
    }

    public void setTransmitted(boolean transmitted) {
        this.transmitted = transmitted;
    }
}
