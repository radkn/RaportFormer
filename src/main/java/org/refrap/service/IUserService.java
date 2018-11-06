package org.refrap.service;

import org.refrap.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
    UserDetails loadUserByUsername(final String username);

}
