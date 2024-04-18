package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.Phoneuser;

@Repository
public interface PhoneRepo extends JpaRepository<Phoneuser,Integer>{

	public Phoneuser findByEmail(String email);
}
