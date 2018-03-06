package com.vueprac.fyni.service;

import com.vueprac.fyni.entity.User;
import com.vueprac.fyni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FyniUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public FyniUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
                AuthorityUtils.createAuthorityList(user.getUserRoles()));
    }

}
