package com.student.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.demo.pojo.Role;
import com.student.demo.pojo.User;

public class RoleDao {
	
	/*public void activeOrInactive(Role user) {
	Connection connection = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
		
		String sql = "update USER_ROLES set  ROLE_ID= ?, USER_ROLE = ?, Active = ?";
		
		
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//preparedStatement.setString(1, user.getactiveorinactive());
		
		preparedStatement.executeUpdate();

		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
		}
	}

}*/
	
	public void save(Role role) {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			
			String sql = "insert into roles(user_role, status) values(?,?)";
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, role.getUser_role());
			preparedStatement.setString(2, role.getStatus());
			
			preparedStatement.executeUpdate();

			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		
	}
	
	public List<Role> findAll() {
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from roles where status=?");
			preparedStatement.setString(1, "y");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			List<Role> roleList = new ArrayList<Role>();
			
			while(resultSet.next()){
				
				Role role = new Role();
				role.setRoleId(resultSet.getInt("roleId"));
				role.setUser_role(resultSet.getString("user_role"));
				role.setStatus(resultSet.getString("status"));
				
				roleList.add(role);
			}
			
			return roleList;
			
		}catch(Exception e){
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
			}
		}
	}

}
