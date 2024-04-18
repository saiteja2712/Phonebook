package com.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.entity.Phoneuser;
import com.phone.service.Phoneserviceinterface;

@RestController
@RequestMapping("/api")

public class PhoneuserController {
	@Autowired
	private Phoneserviceinterface phoneserviceinterface;

	public Phoneserviceinterface getPhoneserviceinterface() {
		return phoneserviceinterface;
	}

	public void setPhoneserviceinterface(Phoneserviceinterface phoneserviceinterface) {
		this.phoneserviceinterface = phoneserviceinterface;
	}
	
	@PostMapping("/insert")
	public Phoneuser save(@RequestBody Phoneuser phoneuser)
	{
		return phoneserviceinterface.save(phoneuser);
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws Exception
	{
		phoneserviceinterface.deleteById(id);
		return "deleted successfully";
		
	}
	@GetMapping("/findall")
	public List<Phoneuser>findAlldetails()
	{
		return phoneserviceinterface.findalldetails();
		
	}

}
