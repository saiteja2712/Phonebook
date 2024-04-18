package com.phone.service;

import java.util.List;

import com.phone.entity.Phoneuser;

public interface Phoneserviceinterface {
	public Phoneuser save(Phoneuser phoneuser);
	public void deleteById(int id) throws Exception;
	public List<Phoneuser> findalldetails();
	public Phoneuser findByEmail(String email);
	public Phoneuser findPhoneuserByJwt(String jwt);
	public Phoneuser findPhoneuserByid(int id) throws Exception;
	

}
