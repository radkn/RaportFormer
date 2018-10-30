package org.refrap.service;

import org.refrap.model.Line;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface ILineService {

    List<Line> getAllLineName();

    List<Line> getAllSceneId();

    List<Line> getLineBySceneid(String sceneId);

    List<Line> getByTitleAndDate(String lineTitle, String date, int timeStart, int timeEnd, String status);

    Map<String, Integer> getCountByTitleAndDate(String lineTitle, String date, int timeStart, int timeEnd, String status);

    List<String> getAllData();
}
