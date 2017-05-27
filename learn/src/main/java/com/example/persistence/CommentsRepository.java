package com.example.persistence;

import com.example.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comment, Integer> {
}
