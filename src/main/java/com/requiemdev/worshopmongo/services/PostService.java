package com.requiemdev.worshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.requiemdev.worshopmongo.domain.Post;
import com.requiemdev.worshopmongo.repositories.PostRepository;
import com.requiemdev.worshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // mecanismo de injeção de dependencia automatica do spring
	private PostRepository repo;


	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
