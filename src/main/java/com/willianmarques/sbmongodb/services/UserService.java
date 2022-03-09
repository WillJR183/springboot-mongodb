package com.willianmarques.sbmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willianmarques.sbmongodb.domain.User;
import com.willianmarques.sbmongodb.dto.UserDTO;
import com.willianmarques.sbmongodb.repositories.UserRepository;
import com.willianmarques.sbmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateDate(newObj, obj);
		return userRepository.save(newObj);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById( String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	private void updateDate(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

}
