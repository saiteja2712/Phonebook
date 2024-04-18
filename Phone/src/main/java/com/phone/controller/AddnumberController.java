package com.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.Response.ApiResponse;
import com.phone.entity.Addnumber;
import com.phone.entity.Phoneuser;
import com.phone.service.Addphoneinterface;
import com.phone.service.Phoneserviceinterface;

@RestController
@RequestMapping("/api")
public class AddnumberController {
	@Autowired
	private Addphoneinterface addphoneinterface;
	@Autowired
	private Phoneserviceinterface phoneserviceinterface;
	
	
	@PostMapping("/number")
	public ResponseEntity<Addnumber>createnum(@RequestHeader("Authorization")String jwt,@RequestBody Addnumber addnumber) throws Exception
	{
		Phoneuser reqUser=phoneserviceinterface.findPhoneuserByJwt(jwt);
		Addnumber addednumber=addphoneinterface.createnum(addnumber, reqUser.getId());
		return new ResponseEntity<>(addednumber,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Addnumber>>findAllNumbers(@RequestHeader("Authorization")String jwt) throws Exception
	{
		System.out.println(jwt);
		Phoneuser reqUser=phoneserviceinterface.findPhoneuserByJwt(jwt);
		List<Addnumber>numbers=addphoneinterface.findAllNumbers(reqUser.getId());
		return new ResponseEntity<List<Addnumber>>(numbers,HttpStatus.OK);
		
	}
	@DeleteMapping("/techmo/{addnumberid}")
	public ResponseEntity<String>deletenumber(@PathVariable int addnumberid,@RequestHeader("Authorization")String jwt) throws Exception
	{
		Phoneuser reqUser=phoneserviceinterface.findPhoneuserByJwt(jwt);
		System.out.println(addnumberid);
		if(addphoneinterface.deletenumber(addnumberid))
		{
			return ResponseEntity.ok("deleted successfully");
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("number not found");
		}
		
		
	}

}
