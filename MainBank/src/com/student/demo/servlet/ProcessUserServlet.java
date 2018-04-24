package com.student.demo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;
import com.student.demo.service.UserService;

public class ProcessUserServlet extends HttpServlet{
	
	
	private UserService userService = new UserService();
	
	private LoginService loginService = new LoginService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
			if(req.getParameter("id") == null || req.getParameter("id").isEmpty()){
			
				try{
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					
					String name = req.getParameter("name");
					String phoneNo = req.getParameter("phoneNo");
					Date dob = dateFormat.parse(req.getParameter("dob"));
					String username = req.getParameter("username");
					String password = req.getParameter("password");
					/*String activeorinactive = req.getParameter("activeorinactive");*/
					
					
					User user = new User();
					user.setName(name);
					user.setPhoneNo(phoneNo);
					user.setDob(dob);
					user.setUsername(username);
					user.setPassword(password);
					/*user.setactiveorinactive(activeorinactive);*/
					
					userService.saveUser(user);
					
					
					List<User> userList =   loginService.findAllUsers();
					
					req.setAttribute("userList", userList);
					
					
					req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
					
				
				
				}catch(Exception e){
					
				}
		
		}else{
			
			try{
			
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				Integer id = Integer.valueOf(req.getParameter("id"));
				String name = req.getParameter("name");
				String phoneNo = req.getParameter("phoneNo");
				Date dob = dateFormat.parse(req.getParameter("dob"));
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				/*String activeorinactive = req.getParameter("activeorinactive");*/
				
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPhoneNo(phoneNo);
				user.setDob(dob);
				user.setUsername(username);
				user.setPassword(password);
				/*user.setactiveorinactive(activeorinactive);*/
				
				userService.updareUser(user);
				
				
				List<User> userList =   loginService.findAllUsers();
				
				req.setAttribute("userList", userList);
				
				
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
				
			
			
			}catch(Exception e){
				
			}
		}
		
		
		
	}
	
}
