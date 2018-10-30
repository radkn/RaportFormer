package org.refrap.dao;

import org.refrap.model.Line;

import java.sql.Timestamp;
import java.util.List;

public interface ILineDAO {

    List<Line> getAllLineName();
    List<Line> getAllSceneId();

    List<Line> getLineBySceneId(String sceneId);
    List<Line> findByTitleDateStatus(String lineTitle, Timestamp dtStart, Timestamp dtEnd, int status);
    Long getCountByTitleDateStatus(String lineTitle, Timestamp dtStart, Timestamp dtEnd, int status);

    List<Line> getAllData();

}
