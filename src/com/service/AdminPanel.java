package com.service;

import java.util.List;

import com.model.Admin;
import com.model.Cashier;

public interface AdminPanel {
	boolean addCashier(Cashier c);
	boolean registerAdmin(Admin a);
	List<Cashier> getCashierData();
	boolean updateCashier(Cashier c);
	boolean deleteCashier(int id);

}
