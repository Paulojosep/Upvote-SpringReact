package com.paulo.upvote.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.upvote.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
