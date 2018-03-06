package com.vueprac.fyni.repository;

import com.vueprac.fyni.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserEmail(String email);

}
