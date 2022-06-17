package com.requiemdev.worshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.requiemdev.worshopmongo.domain.User;
import com.requiemdev.worshopmongo.dto.UserDTO;
import com.requiemdev.worshopmongo.repositories.UserRepository;
import com.requiemdev.worshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // mecanismo de injeção de dependencia automatica do spring
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
