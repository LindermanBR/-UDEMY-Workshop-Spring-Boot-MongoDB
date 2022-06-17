package com.requiemdev.worshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.requiemdev.worshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
//somente com isso ja é possível fazer varias operações com o user
}
