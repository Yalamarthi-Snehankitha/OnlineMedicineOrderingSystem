package com.medicine.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.entity.Admin;
import com.medicine.medicineservice.AdminService;
import com.medicine.repository.AdminRepository;

@Service
public class Adminserviceimpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllRecords() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdmin(String id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).get();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(String id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);;
		
	}
	

}
