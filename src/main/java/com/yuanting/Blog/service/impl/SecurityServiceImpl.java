package com.yuanting.Blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yuanting.Blog.pojo.Role;
import com.yuanting.Blog.pojo.User;
import com.yuanting.Blog.service.UserService;

public class SecurityServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		User user = userService.findUserByUsername(username); 
		if (user == null) { 
			throw new UsernameNotFoundException("user not exist");
		} 
		System.out.println(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(); 
        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        } 
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

}
