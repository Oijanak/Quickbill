package com.service;

import com.model.Admin;
import com.model.Cashier;

public interface UserService {
	
	boolean verifyAdmin(String uname,String pass);
	boolean verifycashier(String email,String pass);
	
	

}
