package org.refrap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.refrap.model.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class HiberLineDAO implements ILineDAO {

    @Autowired(required = false)
    private SessionFactory sessionFactory;

    private Session curentSession(){
        return sessionFactory.openSession();
    }

    @Override
    public List<Line> getAllLineName() {
        return curentSession().createQuery("from Line group by lineTitle", Line.class).list();
    }

    @Override
    public List<Line> getAllSceneId() {
        return curentSession().createQuery("from Line group by scene_id", Line.class).list();
    }

    @Override
    public List<Line> getLineBySceneId(String sceneId) {
        return curentSession().createQuery("from Line where scene_id='"+sceneId+"' group by lineTitle", Line.class).list();
    }

    @Override
    public List<Line> findByTitleDateStatus(String lineTitle, Timestamp dtStart, Timestamp dtEnd, int status) {
        return curentSession().createQuery("FROM Line where lineTitle='"+lineTitle+"'" +
                " and  datetime>='"+dtStart+"' and datetime<'"+dtEnd+"' and status="+status).list();
    }

    @Override
    public Long getCountByTitleDateStatus(String lineTitle, Timestamp dtStart, Timestamp dtEnd, int status) {
/*        Query q = curentSession().createQuery("select count (*) FROM Line where lineTitle= :lineTitle" +
                " and  datetime>= :start and datetime< :end and status= :status");
        q.setParameter("lineTitle", lineTitle);
        q.setParameter("start", dtStart);
        q.setParameter("end", dtEnd);
        q.setParameter("status", status);*/

        Query q = curentSession().createQuery("select count (*) FROM Line where lineTitle='"+lineTitle+"'" +
                " and  datetime>='"+dtStart+"' and datetime<'"+dtEnd+"' and status="+status);
        Long res = Long.valueOf(0);
        List data = q.list();
        if(data.size()>0){
            res = (Long) data.get(0);
        }

        return res;
    }

    @Override
    public List<Line> getAllData() {
        return curentSession().createQuery("from Line group by DATE(datetime)", Line.class).list();
    }


    public List<Line> getByLineTitle(String lineTitle) {
        return curentSession().createQuery("from Line where lineTitle=\'"+lineTitle+"\'", Line.class).list();
    }

}
