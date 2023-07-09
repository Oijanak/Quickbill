package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Db.Database;
import com.model.Product;

public class ProductServiceImpl implements ProductService{

	@Override
	public boolean addProduct(Product p) {
		String sql="Insert into product(productName,pquantity,mrp) values('"+p.getPname()+"','"+p.getPavailable()+"','"+p.getPmrp()+"')";
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
	public boolean updateProduct(Product p) {
		String sql="update product set productName='"+p.getPname()+"',pquantity='"+p.getPavailable()+"',mrp='"+p.getPmrp()+"' where pid='"+p.getPid()+"'";
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
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String sql="Select * from product";
		List<Product> plist=new ArrayList<>();
		Statement st;
		try {
			st = Database.connectDb().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("productName"));
				p.setPavailable(rs.getInt("pquantity"));
				p.setPmrp(rs.getInt("mrp"));
				plist.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return plist;
	}

}
