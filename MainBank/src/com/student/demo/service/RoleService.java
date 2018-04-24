package com.student.demo.service;

	import java.util.List;

import com.student.demo.dao.RoleDao;
	import com.student.demo.pojo.Role;
	import com.student.demo.pojo.User;

public class RoleService {

	
	
	
		private RoleDao roleDao = new RoleDao();
		
		
		

		public void saveRole(Role role) {
			
			roleDao.save(role);
			
		}
		
		public List<Role> findAllRoles() {
			
			return roleDao.findAll();
			
			
		}
	}
	
	

