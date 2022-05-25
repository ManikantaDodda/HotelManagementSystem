package com.project.hotelmanagement.service;

import com.project.hotelmanagement.dao.RoleDao;
import com.project.hotelmanagement.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
    	 Role addRole = new Role();
         addRole.setRoleName(role.getRoleName());
         addRole.setRoleDescription(role.getRoleDescription());
            return roleDao.save(addRole);
    }
}
