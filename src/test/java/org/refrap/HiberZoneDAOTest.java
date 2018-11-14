package org.refrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.refrap.dao.HiberZoneDAO;
import org.refrap.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
public class HiberZoneDAOTest{

//    @Autowired
//    public HiberZoneDAO zoneDAO;
//
//    @Test
//    @Transactional
//    public void CountInZoneByTimeIntervalTest(){
//        zoneDAO = new HiberZoneDAO();
//        int res = zoneDAO.getCountInZoneByTimeInterval("profile1",
//                "intertopZone",
//                Timestamp.valueOf("2018-10-06 10:00:00"),
//                Timestamp.valueOf("2018-10-06 11:00:00"),
//                10,100);
//
//        System.out.println(res);
//    }
//
//    @Test
//    @Transactional
//    public void getAllZoneNameTest(){
//        HiberZoneDAO zoneDAO = new HiberZoneDAO();
//        List<Zone> res = zoneDAO.getAllZoneName();
//        for (Zone z:res){
//            System.out.println(z.getZoneTitle());
//        }
//    }
}
