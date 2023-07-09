package com.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Db.Database;
import com.model.Admin;

public class UserServiceImpl implements UserService {

	

	@Override
	public boolean verifyAdmin(String uname, String pass) {
		
		String sql="select username,password from admininfo";
		
		try {
			Statement st=Database.connectDb().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("username").equals(uname) && rs.getString("password").equals(pass)) {
					return true;
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean verifycashier(String email, String pass) {
		String sql2="select email,password from cashier";
		Statement st;
		try {
			st = Database.connectDb().createStatement();
			ResultSet rs2=st.executeQuery(sql2);
			while(rs2.next()) {
				if(rs2.getString("email").equals(email) && rs2.getString("password").equals(pass)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
