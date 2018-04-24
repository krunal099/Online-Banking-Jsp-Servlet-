package com.student.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.student.demo.pojo.Role;
import com.student.demo.pojo.UserRole;

public class MappingDao {

	public void save(UserRole mapping) {
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");
			
			String sql = "insert into userRole_mapping(userId, roleId) values(?,?)";
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mapping.getUserId());
			preparedStatement.setInt(2, mapping.getRoleId());
			
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
}
