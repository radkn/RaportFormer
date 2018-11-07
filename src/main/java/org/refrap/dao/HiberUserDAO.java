package org.refrap.dao;

import org.hibernate.SessionFactory;
import org.refrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class HiberUserDAO implements IUserDAO{

/*    @Autowired
    @Qualifier("userSF")*/
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {
        List<User> users = new ArrayList<User>();
        users = getSessionFactory().getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0,username)
                .list();

        if(users.size()>0){
            return users.get(0);
        }else {
            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
