package com.project.hotelmanagement.dao;

import com.project.hotelmanagement.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	User findByUserName(String userName);

	//User findByUserName(String userName);
}
