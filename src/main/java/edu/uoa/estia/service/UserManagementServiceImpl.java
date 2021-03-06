package edu.uoa.estia.service;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.controllers.UserManagementController;
import edu.uoa.estia.domain.User;
import edu.uoa.estia.repository.UserRepository;

@Primary // Because this is the default service implementation
@Named("UserManagementServiceImpl") // Equivelant to @Component but standard JSR-330
                                    // the name property to be used if caller wants to specifically inject this implementation
@Service
public class UserManagementServiceImpl implements UserManagementService {

	private static Logger LOG = LoggerFactory.getLogger(UserManagementServiceImpl.class);
	 
	final UserRepository userRepo;
	
    @Autowired
	public UserManagementServiceImpl(final UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	@Override
	public List<User> requestAllUsers() {
		LOG.info("UserManagementServiceImpl. requestAllUsers()");
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
