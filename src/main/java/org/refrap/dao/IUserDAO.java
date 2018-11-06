package org.refrap.dao;

import org.refrap.model.User;

public interface IUserDAO {
    User findByUserName(String username);
}
