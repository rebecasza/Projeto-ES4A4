package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academicPlanner.academicPlanner.User;


import repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public Optional<User> findByID(Long id) {
		return repository.findById(id);
	}
	
	public List<User> getAll(){
		return repository.findAll();
	}
	
	
}
