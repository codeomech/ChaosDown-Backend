package com.programming.techie.springngblog.repository;

import com.programming.techie.springngblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

	User findByEmail(String email);


}
