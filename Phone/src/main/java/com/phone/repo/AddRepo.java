package com.phone.repo;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phone.entity.Addnumber;

@Repository
public interface AddRepo extends JpaRepository<Addnumber,Integer> {
	
	//@Query("select a from Addnumber a where a.id=:id")
	public List<Addnumber>findByPhoneuserId(int id);
	
}
