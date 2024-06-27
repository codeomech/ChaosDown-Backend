package com.programming.techie.springngblog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programming.techie.springngblog.model.Post;

@Repository
public interface PostDao extends CrudRepository< Post,Integer>{

}
