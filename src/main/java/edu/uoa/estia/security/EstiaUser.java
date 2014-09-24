package edu.uoa.estia.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.uoa.estia.domain.Role;
import edu.uoa.estia.domain.User;

public class EstiaUser implements Serializable, UserDetails, CredentialsContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4510285626444363383L;
	private User domainUsr;
	private String pwdCopy;
	private Set<GrantedAuthority> authorities;
	 
	public EstiaUser(User usr){
		domainUsr = usr;
		System.out.println("------------------------- domainUsr = "+domainUsr);
		if(usr!=null)
			pwdCopy = usr.getPassword();
	}
	
	public User getDomainUser(){
		return this.domainUsr;
	}
	
	@Override
	public String getUsername() {
		return domainUsr.getUsername();
	}
	
	@Override
	public String getPassword() {
		return pwdCopy;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authorities == null){
			  authorities = new HashSet<GrantedAuthority>();
			  if((domainUsr.getRoles())!=null){
				  for(Role r:domainUsr.getRoles()){
					  authorities.add(new EstiaGrantedAuthority(r.getType()));
				  }
			  }
			  authorities = Collections.unmodifiableSet(authorities);
	    }
	    return authorities; 
	}

	@Override
	public boolean isAccountNonExpired() {
		return !domainUsr.getType().getType().equalsIgnoreCase("expired");
	}

	@Override
	public boolean isAccountNonLocked() {
		return !domainUsr.getType().getType().equalsIgnoreCase("locked");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !domainUsr.getType().getType().equalsIgnoreCase("credexpired");
	}

	@Override
	public boolean isEnabled() {
		return domainUsr.getType().getType().equalsIgnoreCase("enabled");
	}
	
	@Override
	public void eraseCredentials() {
		pwdCopy = null;
	}

	@Override
	public int hashCode() {
		return domainUsr.getUsername().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
        if (obj instanceof User) {
            return domainUsr.getUsername().equals(((EstiaUser) obj).getUsername());
        }
        return false;
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Username: ").append(this.getUsername()).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Enabled: ").append(this.isEnabled()).append("; ");
        sb.append("AccountNonExpired: ").append(this.isAccountNonExpired()).append("; ");
        sb.append("credentialsNonExpired: ").append(this.isCredentialsNonExpired()).append("; ");
        sb.append("AccountNonLocked: ").append(this.isAccountNonLocked()).append("; ");

        if (!getAuthorities().isEmpty()) {
            sb.append("Granted Authorities: ");

            boolean first = true;
            for (GrantedAuthority auth : getAuthorities()) {
                if (!first) {
                    sb.append(",");
                }
                first = false;

                sb.append(auth);
            }
        } else {
            sb.append("Not granted any authorities");
        }
        if(domainUsr!=null)
        	sb.append("Email: "+domainUsr.getEmail());
        
        return sb.toString();
	}
}
