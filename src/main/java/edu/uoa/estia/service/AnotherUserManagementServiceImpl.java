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

import edu.uoa.estia.domain.User;
import edu.uoa.estia.repository.UserRepository;

@Named("AnotherUserManagementServiceImpl")
@Service
public class AnotherUserManagementServiceImpl implements UserManagementService {

	private static Logger LOG = LoggerFactory.getLogger(AnotherUserManagementServiceImpl.class);
	
	final UserRepository userRepo;
	
    @Autowired
	public AnotherUserManagementServiceImpl(final UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	@Override
	public List<User> requestAllUsers() {
		LOG.info("AnotherUserManagementServiceImpl. requestAllUsers()");
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
