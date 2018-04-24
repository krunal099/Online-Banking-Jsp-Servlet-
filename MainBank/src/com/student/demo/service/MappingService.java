package com.student.demo.service;

import com.student.demo.dao.MappingDao;
import com.student.demo.dao.UserDao;
import com.student.demo.pojo.User;
import com.student.demo.pojo.UserRole;

public class MappingService {
	private MappingDao mappingDao = new MappingDao();
	
	public void saveMapping(UserRole mapping) {
		
		mappingDao.save(mapping);

	}
}
