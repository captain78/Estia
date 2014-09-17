package edu.uoa.estia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uoa.estia.domain.User;

@Service
public interface UserManagementService {

	public List<User> requestAllUsers();
	
	public User requestUserById(String id);
	
	public User requestUserByUsername(String username);
	
}
