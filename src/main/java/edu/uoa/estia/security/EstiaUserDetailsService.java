package edu.uoa.estia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.uoa.estia.domain.User;
import edu.uoa.estia.repository.UserRepository;

@Service
public class EstiaUserDetailsService implements UserDetailsService {

    private UserRepository repository;
    
    @Autowired
    public EstiaUserDetailsService(UserRepository repository )
    {
        this.repository = repository;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User domainUsr = repository.findByUsername(username);
		if(domainUsr==null) 
	    	throw new UsernameNotFoundException("Username '"+username+"' was not found in estia database");
	    return new EstiaUser(domainUsr);
	}

}
