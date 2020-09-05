package com.mateus.os.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.os.api.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
