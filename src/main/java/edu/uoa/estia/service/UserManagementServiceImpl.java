package edu.uoa.estia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uoa.estia.domain.User;
import edu.uoa.estia.repository.UserRepository;

@Component("UserManagementServiceImpl")
public class UserManagementServiceImpl implements UserManagementService {

	final UserRepository userRepo;
	
    @Autowired
	public UserManagementServiceImpl(final UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	@Override
	public List<User> requestAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User requestUserById(String id) {
		return userRepo.findOne(Integer.parseInt(id));
	}

	@Override
	public User requestUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
