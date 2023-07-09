package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Db.Database;
import com.model.Admin;
import com.model.Cashier;

public class AdminPanelImpl implements AdminPanel{

	@Override
	public boolean addCashier(Cashier c) {
		String sql="insert into cashier(id,name,mobile,address,email,password) values('"+c.getCuid()+"','"+c.getCuname()+"','"+c.getCunumber()+"','"+c.getCuaddress()+"','"+c.getCuemail()+"','"+c.getCupass()+"')";
		try {
			Statement st=Database.connectDb().createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean registerAdmin(Admin a) {
	
		
	
		String sql="insert into admininfo(firstName,lastName,username,password,address,birthdate) values('"+a.getFirstName()+"','"+a.getLastName()+"','"+a.getAdminusername()+"','"+a.getAdminpassword()+"','"+a.getAddress()+"','"+a.getBirthdate()+"')";
		
		try {
			Statement st=Database.connectDb().createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public List<Cashier> getCashierData() {
		String sql="Select * from cashier";
		
		List<Cashier> clist=new ArrayList<>();
		try {
			Statement st=Database.connectDb().createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Cashier c=new Cashier();
				c.setCuid(rs.getInt("id"));
				c.setCuname(rs.getString("name"));
				c.setCunumber(rs.getString("mobile"));
				c.setCuaddress(rs.getString("address"));
				c.setCuemail(rs.getString("email"));
				c.setCupass(rs.getString("password"));
				clist.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}
	@Override
	public boolean updateCashier(Cashier c) {
		String sql="update cashier set name='"+c.getCuid()+"', mobile='"+c.getCunumber()+"', address='"+c.getCuaddress()+"', email='"+c.getCuemail()+"',password='"+c.getCupass()+"' where id='"+c.getCuid()+"'";
		try {
			Statement st=Database.connectDb().createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean deleteCashier(int id) {
		String sql="delete from cashier where id="+id;
		try {
			Statement st=Database.connectDb().createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
