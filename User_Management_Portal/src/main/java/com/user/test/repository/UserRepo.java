package com.user.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.user.test.entity.OurUser;


public interface UserRepo extends JpaRepository<OurUser,Long>{
	
	
}
	