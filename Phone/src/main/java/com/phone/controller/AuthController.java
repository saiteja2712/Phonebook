package com.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.Response.AuthResponse;
import com.phone.config.JwtProvider;
import com.phone.entity.Phoneuser;
import com.phone.loginRequest.LoginRequest;
import com.phone.repo.PhoneRepo;
import com.phone.service.CustomerUserDetailsService;
import com.phone.service.Phoneserviceinterface;

@RestController
@RequestMapping("/auth")

public class AuthController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Phoneserviceinterface phoneserviceinterface;
	@Autowired
	private PhoneRepo phonerepo;
	@Autowired 
	private CustomerUserDetailsService customerUserDetails;
	
	
	@PostMapping("/signup")
	public AuthResponse createPhoneuser(@RequestBody Phoneuser phoneuser) throws Exception
	{
		Phoneuser isExist=phonerepo.findByEmail(phoneuser.getEmail());
		if(isExist!=null)
		{
			throw new Exception("email already used with another account");
		}
		Phoneuser user=new Phoneuser();
		user.setFirstname(phoneuser.getFirstname());
		user.setLastname(phoneuser.getLastname());
		user.setEmail(phoneuser.getEmail());
		user.setMobilenumber(phoneuser.getMobilenumber());
		user.setPassword(passwordEncoder.encode(phoneuser.getPassword()));
		Phoneuser saveduser=phonerepo.save(user);
		
		Authentication authentication=new UsernamePasswordAuthenticationToken(saveduser.getFirstname(),saveduser.getPassword());
		
		String token=JwtProvider.generateToken(authentication);
		
		AuthResponse res=new AuthResponse(token,"Register success");
		return res;
	}

	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest)
	{
		
		Authentication authentication=authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token=JwtProvider.generateToken(authentication);
		AuthResponse res=new AuthResponse(token,"Login success");
		return res;
	}

	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		UserDetails userDetails=customerUserDetails.loadUserByUsername(email);
		if(userDetails==null)
		{
			throw new BadCredentialsException("invalid username");
		}
		if(!password.equals(userDetails.getPassword()))
		{
			throw new BadCredentialsException("password not matched");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
}
