package com.requiemdev.worshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.requiemdev.worshopmongo.domain.User;
import com.requiemdev.worshopmongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired //mecanismo de injeção de dependencia automatica do spring
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
}
