package com.vueprac.fyni.util;

import com.vueprac.fyni.entity.Event;
import com.vueprac.fyni.entity.User;
import com.vueprac.fyni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Event.class)
public class UserEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HandleBeforeCreate
    public void applyUserInformationUsingSecurityContext(Event event) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = this.userRepository.findByUserEmail(name);
        if (user == null) {
            // need a logic that sends users to sign up url
        }
        event.setUser(user);
    }
}
