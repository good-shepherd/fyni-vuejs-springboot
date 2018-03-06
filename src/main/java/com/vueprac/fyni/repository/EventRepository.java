package com.vueprac.fyni.repository;

import com.vueprac.fyni.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
public interface EventRepository extends CrudRepository<Event, Long> {

    @Override
    Event save(@Param("event") Event event);

    @Override
    void deleteById(@Param("id") Long id);

    @Override
    void delete(@Param("event") Event event);
}
