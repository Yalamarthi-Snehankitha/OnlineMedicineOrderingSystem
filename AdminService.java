package com.medicine.medicineservice;

import java.util.List;

import com.medicine.entity.Admin;


public interface AdminService {
		
		List<Admin> getAllRecords();
		
		Admin saveAdmin(Admin admin);
		
		Admin getAdmin(String id);
		
		Admin updateAdmin(Admin admin);
		
		void deleteAdmin(String id);


}
