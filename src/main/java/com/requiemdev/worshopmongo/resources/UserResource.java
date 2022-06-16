package com.requiemdev.worshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.requiemdev.worshopmongo.domain.User;
import com.requiemdev.worshopmongo.services.UserService;

@RestController //Indica que essa entidade é um controlador rest
@RequestMapping(value = "/users") // indica que ela responde pelo caminho /users
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
