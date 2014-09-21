package edu.uoa.estia.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.uoa.estia.service.UserManagementService;
import edu.uoa.estia.domain.User;


@Controller
@RequestMapping("/services/users")
public class UserManagementController {

	    private static Logger LOG = LoggerFactory.getLogger(UserManagementController.class);

	    /*
	    @Resource(name="AnotherUserManagementServiceImpl")  
	    
	    if you want to pick a specific service implementation. 
	    The name attribute must be paired with a @Component("beanID") in the bean declaration.
	    In this case, the AnotherSearchServiceImpl bean should be declared as:
	                                               
	    @Component("AnotherSearchServiceImpl")
	    public class AnotherSearchServiceImpl() { }
	    
	    */
	    @Autowired
		private UserManagementService userService;

	    
	    @RequestMapping( method = RequestMethod.GET, value = "/all")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public List<User> getAllUsers() {
	        return userService.requestAllUsers();
	    }
	    
	    @RequestMapping( method = RequestMethod.GET, value = "/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public ResponseEntity<User> getUserById(@PathVariable String id) {
	        
	    	User user = userService.requestUserById(id);
	        if (user==null) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	    
	    @RequestMapping( method = RequestMethod.GET, value = "/name/{username}")
	    @ResponseStatus(HttpStatus.OK)
	    @ResponseBody
	    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	        
	    	User user = userService.requestUserByUsername(username);
	        if (user==null) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	   
	    
}
