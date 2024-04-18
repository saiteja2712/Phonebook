package com.phone.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phone.entity.Phoneuser;
import com.phone.repo.PhoneRepo;
@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private PhoneRepo phonerepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Phoneuser phoneuser=phonerepo.findByEmail(username);
		if(phoneuser==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		List<GrantedAuthority>authorities=new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(phoneuser.getEmail(), phoneuser.getPassword(), authorities);
	}
	

}
