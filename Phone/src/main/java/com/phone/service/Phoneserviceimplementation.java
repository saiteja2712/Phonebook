package com.phone.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.phone.config.JwtProvider;
import com.phone.entity.Phoneuser;
import com.phone.repo.PhoneRepo;
@Service
public class Phoneserviceimplementation implements Phoneserviceinterface {

	@Autowired
	private PhoneRepo phonerepo;
	@Override
	public Phoneuser save(Phoneuser phoneuser) {
		// TODO Auto-generated method stub
		Phoneuser user=new Phoneuser();
		user.setFirstname(phoneuser.getFirstname());
		user.setLastname(phoneuser.getLastname());
		user.setEmail(phoneuser.getEmail());
		user.setMobilenumber(phoneuser.getMobilenumber());
		user.setPassword(phoneuser.getPassword());
		return phonerepo.save(user);
		
		
		
	}

	@Override
	public void deleteById(@PathVariable int id) throws Exception {
		Optional<Phoneuser>phoneuser=phonerepo.findById(id);
		if(phoneuser.isEmpty())
		{
			throw new Exception ("User not exists");
		}
		// TODO Auto-generated method stub
		phonerepo.deleteById(id);
	}

	@Override
	public List<Phoneuser> findalldetails() {
		// TODO Auto-generated method stub
		return phonerepo.findAll();
		
	}

	@Override
	public Phoneuser findByEmail(String email) {
		// TODO Auto-generated method stub
		return phonerepo.findByEmail(email);	}

	@Override
	public Phoneuser findPhoneuserByJwt(String jwt) {
		// TODO Auto-generated method stub
		String email=JwtProvider.getEmailFromJwtToken(jwt);
		Phoneuser phoneuser=phonerepo.findByEmail(email);
		return phoneuser;
	}

	@Override
	public Phoneuser findPhoneuserByid(int id) throws Exception {
		Optional<Phoneuser>phoneuser=phonerepo.findById(id);
		if(phoneuser.isPresent())
		{
			return phoneuser.get();
		}
		// TODO Auto-generated method stub
		throw new Exception ("user not found with "+id);
	}

}
