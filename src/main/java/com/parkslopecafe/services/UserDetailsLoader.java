package com.parkslopecafe.services;

import com.parkslopecafe.models.User;
import com.parkslopecafe.models.UserWithRole;
import com.parkslopecafe.repositories.Roles;
import com.parkslopecafe.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>The <code>UserDetailsLoader</code> class is a service used to implement Spring Security
 * features for authentication and authorization.</p>
 *
 * @author David Ryan Alviola
 * @since August 2017
 */
@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;
    private final Roles roles;

    @Autowired
    public UserDetailsLoader(Users users, Roles roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRole(user, userRoles);
    }
}
