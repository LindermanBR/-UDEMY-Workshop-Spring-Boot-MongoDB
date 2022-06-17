package com.requiemdev.worshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.requiemdev.worshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
//somente com isso ja é possível fazer varias operações com o user
	
	//Querry Method usando o spring para gerar consultas no mongo usando somente o titulo e parametros
	List<Post> findByTitleContainingIgnoreCase(String text);
}
