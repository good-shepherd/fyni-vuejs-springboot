package com.vueprac.fyni.util;

import com.vueprac.fyni.entity.Event;
import com.vueprac.fyni.entity.User;
import com.vueprac.fyni.repository.EventRepository;
import com.vueprac.fyni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        User binna = this.userRepository.save(new User("binna@gmail.com", "12345", "bing",
                "444 Washington Blvd.", "100.12412", "23.23555", 0,
                false, "ROLE_USER"));

        User shooki = this.userRepository.save(new User("shooki@gmail.com", "1234",
                "shoo","475 Washington Blvd.", "123.3355",
                "36.235235",0, true, "ROLE_USER"));

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("shooki@gmail.com",
                "doesn't matter", AuthorityUtils.createAuthorityList("ROLE_USER")));

        this.eventRepository.save(new Event("title", "content", 0, new Date(), new Date(), "pictureurl", "address", "123.5444",
                "12.13515", shooki));

        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("binna@gmail.com",
                "doesn't matter", AuthorityUtils.createAuthorityList("ROLE_USER")));

        this.eventRepository.save(new Event("title1", "con23tent", 0, new Date(), new Date(), "pictureurl", "address", "123.5444",
                "12.1324515", binna));

        SecurityContextHolder.clearContext();

        System.out.println(binna);
        System.out.println(shooki);
    }
}
