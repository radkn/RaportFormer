package org.refrap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="line")
public class Line {

    @Id
    private long id;

    private String scene_id;
    private String lineTitle;
    private String uid;
    private Timestamp datetime;
    private int status;
    private int type;
    private Timestamp time_stamp;
    private boolean transmitted;

    public long getId() {
        return id;
    }

    public String getScene_id() {
        return scene_id;
    }

    public String getLineTitle() {
        return lineTitle;
    }

    public String getUid() {
        return uid;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public boolean isTransmitted() {
        return transmitted;
    }

}
