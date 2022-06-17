package com.requiemdev.worshopmongo.services;

import java.util.Date;
import java.util.List;
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

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post>findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000));
		return repo.fullSearch(text, minDate, maxDate);
	}
}
