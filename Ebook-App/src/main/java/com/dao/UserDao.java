package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean register(User u) {
		boolean f = false;
		try {
			String sql="insert into user(username, password, email) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,u.getFullname() );
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
