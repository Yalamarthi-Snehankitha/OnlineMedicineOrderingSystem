package com.medicine.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,String> {

}
