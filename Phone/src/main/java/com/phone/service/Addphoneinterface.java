package com.phone.service;

import java.util.List;

import com.phone.entity.Addnumber;

public interface Addphoneinterface {
	public Addnumber createnum(Addnumber addnumber,int id) throws Exception;
	public List<Addnumber>findAllNumbers(int id) throws Exception;
	public boolean deletenumber(int addnumberid);
	public Addnumber findnumberByid(int addnumberid) throws Exception;
	

}
