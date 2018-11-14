package org.refrap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.refrap.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class HiberZoneDAO implements IZoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session curentSession(){
        return sessionFactory.openSession();
    }


    @Override
    public List<Zone> getAllZoneName() {
        return curentSession().createQuery("from Zone group by zoneTitle", Zone.class).list();

    }

    @Override
    public List<Zone> getAllSceneId() {
        return curentSession().createQuery("from Zone group by scene_id", Zone.class).list();
    }

    @Override
    public Long getCountInZoneMoreTimeInterval(String scene_id, String zoneTitle,
                                              Timestamp tStart, Timestamp tEnd, int delay) {

        Query query = curentSession().createQuery("select count(*) FROM Zone where scene_id= :scene_id and " +
                "zoneTitle= :zoneTitle and datetime_start>= :tStart and datetime_end< :tEnd and datetime_delay>= :delay")
                .setParameter("scene_id", scene_id)
                .setParameter("zoneTitle", zoneTitle)
                .setParameter("tStart", tStart)
                .setParameter("tEnd", tEnd)
                .setParameter("delay", delay);

        Long res = Long.valueOf(0);
        List data = query.list();
        if(data.size()>0){
            res = (Long) data.get(0);
        }

        return res;
    }

    @Override
    public Long getCountInZoneLessTimeInterval(String scene_id, String zoneTitle,
                                              Timestamp tStart, Timestamp tEnd, int delay) {

        Query query = curentSession().createQuery("select count (*) FROM Zone where scene_id= :scene_id and " +
                "zoneTitle= :zoneTitle and datetime_start>= :tStart and datetime_end< :tEnd and datetime_delay< :delay")
                .setParameter("scene_id", scene_id)
                .setParameter("zoneTitle", zoneTitle)
                .setParameter("tStart", tStart)
                .setParameter("tEnd", tEnd)
                .setParameter("delay", delay);

        Long res = Long.valueOf(0);
        List data = query.list();
        if(data.size()>0){
            res = (Long) data.get(0);
        }

        return res;
    }

    @Override
    public Long getCountInZoneByTimeInterval(String scene_id, String zoneTitle,
                                             Timestamp tStart, Timestamp tEnd,
                                             int delay_min, int delay_max) {
        Query query = curentSession().createQuery("select count (*) FROM Zone where scene_id= :scene_id and " +
                "zoneTitle= :zoneTitle and datetime_start>= :tStart and datetime_end< :tEnd and datetime_delay>= :delay_min and datetime_delay< :delay_max")
                .setParameter("scene_id", scene_id)
                .setParameter("zoneTitle", zoneTitle)
                .setParameter("tStart", tStart)
                .setParameter("tEnd", tEnd)
                .setParameter("delay_min", delay_min)
                .setParameter("delay_max", delay_max);

        Long res = Long.valueOf(0);
        List data = query.list();
        if(data.size()>0){
            res = (Long) data.get(0);
        }

//        Query query1 = curentSession().createQuery("FROM Zone where scene_id= :scene_id and " +
//                "zoneTitle= :zoneTitle and datetime_start>= :tStart and datetime_end< :tEnd and datetime_delay>= :delay_min and datetime_delay< :delay_max", Zone.class)
//                .setParameter("scene_id", scene_id)
//                .setParameter("zoneTitle", zoneTitle)
//                .setParameter("tStart", tStart)
//                .setParameter("tEnd", tEnd)
//                .setParameter("delay_min", delay_min)
//                .setParameter("delay_max", delay_max);
//
//        List<Zone> zones = query1.list();
//        System.out.println(zones.get(0).getDatetime_start());

        return res;
    }
}
