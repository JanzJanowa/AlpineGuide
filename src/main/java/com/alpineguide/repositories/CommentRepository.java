package com.alpineguide.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alpineguide.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
