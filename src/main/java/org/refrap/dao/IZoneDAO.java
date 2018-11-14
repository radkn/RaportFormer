package org.refrap.dao;

import org.refrap.model.Zone;

import java.sql.Timestamp;
import java.util.List;

public interface IZoneDAO {
    List<Zone> getAllZoneName();
    List<Zone> getAllSceneId();
    Long getCountInZoneMoreTimeInterval(String scene_id, String zoneTitle, Timestamp tStart, Timestamp tEnd, int datetime_delay);
    Long getCountInZoneLessTimeInterval(String scene_id, String zoneTitle, Timestamp tStart, Timestamp tEnd, int datetime_delay);
    Long getCountInZoneByTimeInterval(String scene_id, String zoneTitle, Timestamp tStart, Timestamp tEnd, int datetime_delay_min, int datetime_delay_max);
}
