package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.Post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
