package com.medicine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.entity.Admin;
import com.medicine.repository.AdminRepository;
import com.medicine.serviceimpl.Adminserviceimpl;


@RestController
@RequestMapping("/onlineMedicine")
public class AdminController {
	
	@Autowired
    Adminserviceimpl adminserviceimpl;
	@Autowired
	AdminRepository adminRepository;
	
	
	
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>>getAllAdmins()
	{
		List<Admin> newadmin=adminserviceimpl.getAllRecords();
		return new ResponseEntity<>(newadmin,HttpStatus.OK);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		Admin newadmin=adminserviceimpl.saveAdmin(admin);
		return new ResponseEntity<>(newadmin,HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
		Optional<Admin> checkadmin=adminRepository.findById(id);
		if(checkadmin.isPresent())
		{
		Admin admin=adminserviceimpl.getAdmin(id);
		return new ResponseEntity<>(admin,HttpStatus.OK);
		}
		else
		{
			System.out.println("this login id is not present");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable String id,@RequestBody Admin admin) {
		Optional<Admin> checkadmin=adminRepository.findById(id);
		if(checkadmin.isPresent())
		{
		Admin updateadmin=new Admin();
		updateadmin.setLoginid(admin.getLoginid());
		updateadmin.setPassword(admin.getPassword());
		Admin updateadminnew=adminserviceimpl.updateAdmin(admin);
		return new ResponseEntity<>(updateadminnew,HttpStatus.OK);
		}
		else
		{
			System.out.println("this login id is not present");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable String id)
	{
		Optional<?> checkadmin=adminRepository.findById(id);
		if(checkadmin.isPresent())
		{
		adminserviceimpl.deleteAdmin(id);
		System.out.println("Record deleted");
		return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			System.out.println("this login id is not present");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
