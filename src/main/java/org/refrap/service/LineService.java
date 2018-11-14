package org.refrap.service;

import org.refrap.dao.HiberZoneDAO;
import org.refrap.dao.ILineDAO;
import org.refrap.dao.IZoneDAO;
import org.refrap.model.Line;
import org.refrap.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class LineService<TODO> implements ILineService {

    @Autowired
    public ILineDAO lineDAO;

    @Autowired
    public IZoneDAO zoneDAO;

    @Override
    public List<Line> getAllLineName() {

        return lineDAO.getAllLineName();
    }



    @Override
    public List<Line> getAllSceneId() {
        zoneTest();
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
    public Map<String, Integer> getCountByTitleAndDate(String scene, String lineTitle, String date, int timeStart, int timeEnd, String status) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for(; timeEnd>timeStart; timeStart++){
            int s = status.equals("in")?1:0;
            Long count = lineDAO.getCountByTitleDateStatus(scene,lineTitle, Timestamp.valueOf(date+" "+timeStart+":00:00"),
                    Timestamp.valueOf(date+" "+(timeStart+1)+":00:00"), s);
            map.put(String.valueOf(timeStart), count.intValue());
        }

        return map;
    }

    @Override
    public List<String> getAllData() {

        List<Line> lines = lineDAO.getAllData();
        List<String> dates = new ArrayList <String>();

        for (Line l :lines) {
            dates.add(l.getDatetime().toString().substring(0,10));
        }
        return dates;
    }


    //TODO:DELETE
    private void zoneTest() {

        //******************
        List<Zone> res = zoneDAO.getAllZoneName();
        System.out.println("getAllZoneName result: ");
        for (Zone z:res){
            System.out.println(z.getZoneTitle());
        }


        //******************
        List<Zone> res1 = zoneDAO.getAllSceneId();
        System.out.println("getAllSceneId result: ");
        for (Zone z:res1){
            System.out.println(z.getScene_id());
        }


        //******************
        Long res2 = zoneDAO.getCountInZoneByTimeInterval("profile1",
                "intertopZone",
                Timestamp.valueOf("2018-10-06 14:00:00"),
                Timestamp.valueOf("2018-10-06 14:59:00"),
                0,100);

        System.out.println("getCountInZoneByTimeInterval result: " + res2);

        //******************
        Long res3 = zoneDAO.getCountInZoneMoreTimeInterval("profile1",
                "intertopZone",
                Timestamp.valueOf("2018-10-06 13:00:00"),
                Timestamp.valueOf("2018-10-06 13:59:00"),
                0);

        System.out.println("getCountInZoneMoreTimeInterval result: " + res3);

        Long res4 = zoneDAO.getCountInZoneLessTimeInterval("profile1",
                "intertopZone",
                Timestamp.valueOf("2018-10-06 13:00:00"),
                Timestamp.valueOf("2018-10-06 13:59:00"),
                110);

        System.out.println("getCountInZoneLessTimeInterval result: " + res4);
    }
}
