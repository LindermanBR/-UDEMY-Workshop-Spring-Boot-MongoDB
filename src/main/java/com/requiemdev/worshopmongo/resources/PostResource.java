package com.requiemdev.worshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.requiemdev.worshopmongo.domain.Post;
import com.requiemdev.worshopmongo.resources.util.URL;
import com.requiemdev.worshopmongo.services.PostService;

@RestController //Indica que essa entidade é um controlador rest
@RequestMapping(value = "/posts") // indica que ela responde pelo caminho /users
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll() {
		List<Post> post = service.findAll();
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

}
