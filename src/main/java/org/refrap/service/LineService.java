package org.refrap.service;

import org.refrap.dao.ILineDAO;
import org.refrap.model.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class LineService implements ILineService {

    @Autowired
    public ILineDAO lineDAO;

    @Override
    public List<Line> getAllLineName() {
        return lineDAO.getAllLineName();
    }

    @Override
    public List<Line> getAllSceneId() {
        return lineDAO.getAllSceneId();
    }

    @Override
    public List<Line> getLineBySceneid(String sceneId) {
        return lineDAO.getLineBySceneId(sceneId);
    }

    @Override
    public List<Line> getByTitleAndDate(String lineTitle, String date, int timeStart, int timeEnd, String status) {

        Timestamp tStart = new Timestamp(timeStart*60*60*1000);
        Timestamp tEnd = new Timestamp(timeEnd*60*60*1000);

        return lineDAO.findByTitleDateStatus(lineTitle, Timestamp.valueOf(date+" "+timeStart+":00:00"),Timestamp.valueOf(date+" "+timeEnd+":00:00"), status.equals("one")?1:0);
    }

    @Override
    public Map<String, Integer> getCountByTitleAndDate(String lineTitle, String date, int timeStart, int timeEnd, String status) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(; timeEnd>timeStart; timeStart++){
            int s = status.equals("in")?1:0;
            Long count = lineDAO.getCountByTitleDateStatus(lineTitle, Timestamp.valueOf(date+" "+timeStart+":00:00"),
                    Timestamp.valueOf(date+" "+(timeStart+1)+":00:00"), s);
            map.put(String.valueOf(timeStart), count.intValue());
        }

        return map;
    }

    @Override
    public List<String> getAllData() {

        List<Line> lines = lineDAO.getAllData();
        List<String> dates = new ArrayList<String>();

        for (Line l :lines) {
            dates.add(l.getDatetime().toString().substring(0,10));
        }
        return dates;
    }
}
