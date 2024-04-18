package com.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.entity.Addnumber;
import com.phone.entity.Phoneuser;
import com.phone.repo.AddRepo;
import com.phone.repo.PhoneRepo;

import jakarta.transaction.Transactional;
@Service
public class Addnumberphoneimpl implements Addphoneinterface{

	@Autowired
	private AddRepo addrepo;
	@Autowired
	private Phoneserviceinterface phoneserviceinterface;
	@Autowired
	private PhoneRepo phonerepo;
	@Override
	public Addnumber createnum(Addnumber addnumber, int id) throws Exception {
		// TODO Auto-generated method stub
		
		//Optional<Phoneuser>user=phonerepo.findById(id);
		Phoneuser phoneuser=phoneserviceinterface.findPhoneuserByid(id);
		Addnumber num=new Addnumber();
		num.setMobilenumber(addnumber.getMobilenumber());
		num.setName(addnumber.getName());
		num.setPhoneuser(phoneuser);
		
		return addrepo.save(num);
		}
	

	@Override
	public List<Addnumber> findAllNumbers(int id) throws Exception {
		// TODO Auto-generated method stub
		phoneserviceinterface.findPhoneuserByid(id);
		 return addrepo.findByPhoneuserId(id);
		 
	}

	
	@Override
	public Addnumber findnumberByid(int addnumberid) throws Exception {
		// TODO Auto-generated method stub
		Optional<Addnumber>opt=addrepo.findById(addnumberid);
		if(opt.isEmpty())
		{
			throw new Exception("Number not found with"+addnumberid);
		}
		return opt.get();
	}


	@Transactional
	public boolean deletenumber(int addnumberid) {
		// TODO Auto-generated method stub
		if(addrepo.existsById(addnumberid))
		{
			addrepo.deleteById(addnumberid);
			return true;
		}
		return false;
	}

}
