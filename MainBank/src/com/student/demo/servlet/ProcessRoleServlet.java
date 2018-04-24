package com.student.demo.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.pojo.Role;
import com.student.demo.pojo.User;
import com.student.demo.pojo.UserRole;
import com.student.demo.service.MappingService;
import com.student.demo.service.RoleService;
import com.student.demo.service.UserService;


public class ProcessRoleServlet extends HttpServlet{

	
	private RoleService roleService = new RoleService();
	private UserService userService = new UserService();
	private MappingService mappingService = new MappingService();
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
				if(req.getParameter("userId") != null && req.getParameter("roleId") != null) {
					UserRole userRole = new UserRole();
					int userId = Integer.parseInt(req.getParameter("userId"));
					int roleId = Integer.parseInt(req.getParameter("roleId"));
					userRole.setRoleId(roleId);
					userRole.setUserId(userId);
					
					mappingService.saveMapping(userRole);
					
					
				}
				else {
					String name = req.getParameter("name");
					String activeorinactive = req.getParameter("status");
					
					
					Role role = new Role();
					role.setUser_role(name);
					role.setStatus(activeorinactive);
					
					
					
					roleService.saveRole(role);
					
					
					
					req.getRequestDispatcher("roleentry.jsp").forward(req, resp);
				}
				
				
			
			
		
	
	
	
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = roleService.findAllRoles();
		List<User> users = userService.findAllUsers();
		
		
		req.setAttribute("roles", roles);
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("roleentry.jsp").forward(req, resp);
		
	}
	
	
	
}