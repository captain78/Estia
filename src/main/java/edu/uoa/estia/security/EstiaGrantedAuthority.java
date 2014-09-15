package edu.uoa.estia.security;

import org.springframework.security.core.GrantedAuthority;

public class EstiaGrantedAuthority implements GrantedAuthority {
	private static final long serialVersionUID = 1029928088340565343L;

	private String rolename;

	public EstiaGrantedAuthority(String rolename) {
		this.rolename = rolename;
	}

	public String getAuthority() {
		return this.rolename;
	}

}