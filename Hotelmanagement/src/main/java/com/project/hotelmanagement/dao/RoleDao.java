package com.project.hotelmanagement.dao;

import com.project.hotelmanagement.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {

}
