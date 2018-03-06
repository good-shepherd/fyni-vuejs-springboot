package com.vueprac.fyni.repository;

import com.vueprac.fyni.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
