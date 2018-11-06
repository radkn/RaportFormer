package org.refrap.service;

import org.refrap.dao.HiberUserDAO;
import org.refrap.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private HiberUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        org.refrap.model.User user = userDAO.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        return buildUserForAuthhentication(user, authorities);
    }

    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthhentication(org.refrap.model.User user,
                                             List<GrantedAuthority> authorities){

            return new User(user.getUsername(),
                    user.getPassword(), user.isEnabled(),
                    true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

        return result;
    }

    public HiberUserDAO getUserDao() {
        return userDAO;
    }

    public void setUserDao(HiberUserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
