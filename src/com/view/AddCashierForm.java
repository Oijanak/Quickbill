package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Cashier;
import com.service.AdminPanel;
import com.service.AdminPanelImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCashierForm extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nametxt;
	private JTextField number;
	private JTextField addresstxt;
	private JTextField email;
	private JPasswordField password;
	private JScrollPane scrollPane;
	private JTable table;
	JButton addbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashierForm frame = new AddCashierForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCashierForm() {
		setTitle("Add Cashier");
		setBounds(100, 100, 909, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Cashier Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(73, 11, 146, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier id");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 58, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBounds(147, 55, 108, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cashier Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(27, 93, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		nametxt = new JTextField();
		nametxt.setBounds(147, 86, 108, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" Mobile Number");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(27, 119, 96, 16);
		contentPane.add(lblNewLabel_3);
		
		number = new JTextField();
		number.setBounds(147, 117, 108, 20);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(27, 155, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		addresstxt = new JTextField();
		addresstxt.setBounds(147, 148, 108, 20);
		contentPane.add(addresstxt);
		addresstxt.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(27, 193, 46, 14);
		contentPane.add(lblNewLabel_4_1);
		
		email = new JTextField();
		email.setBounds(147, 190, 108, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Password");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(27, 229, 64, 14);
		contentPane.add(lblNewLabel_4_2);
		
		password = new JPasswordField();
		password.setBounds(147, 226, 108, 20);
		contentPane.add(password);
		
		addbtn = new JButton("Add New");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cid =Integer.parseInt(id.getText());
				String cname=nametxt.getText();
				String cnumber=number.getText();
				String address=addresstxt.getText();
				String cemail=email.getText();
				String cpass=password.getText();
				Cashier c=new Cashier();
				c.setCuid(cid);
				c.setCuname(cname);
				c.setCunumber(cnumber);
				c.setCuaddress(address);
				c.setCuemail(cemail);
				c.setCupass(cpass);
				AdminPanel ap=new AdminPanelImpl();
				if(ap.addCashier(c)) {
					JOptionPane.showMessageDialog(null, "Cashier Added");
					displayData();
				}else {
					JOptionPane.showMessageDialog(null, "Cannot be Added");
				}
				
			}
		});
		
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		addbtn.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-add-new-50.png"));
		addbtn.setBounds(10, 286, 146, 54);
		contentPane.add(addbtn);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Select row first");
					return;
				}
				int cid =Integer.parseInt(id.getText());
				String cname=nametxt.getText();
				String cnumber=number.getText();
				String address=addresstxt.getText();
				String cemail=email.getText();
				String cpass=password.getText();
				Cashier c=new Cashier();
				c.setCuid(cid);
				c.setCuname(cname);
				c.setCunumber(cnumber);
				c.setCuaddress(address);
				c.setCuemail(cemail);
				c.setCupass(cpass);
				AdminPanel ap=new AdminPanelImpl();
				if(ap.updateCashier(c)) {
					JOptionPane.showMessageDialog(null, "Update Success");
					displayData();
					addbtn.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Update Failed");
				}
				
			}
		});
		update.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-update-30.png"));
		update.setFont(new Font("Tahoma", Font.BOLD, 12));
		update.setBounds(166, 286, 123, 54);
		contentPane.add(update);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int srow=table.getSelectedRow();
				int id=(int) table.getValueAt(srow, 0);
				AdminPanel ap=new AdminPanelImpl();
				if(ap.deleteCashier(id)) {
					JOptionPane.showMessageDialog(null, "Deleted");
					displayData();
					addbtn.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Deletion Failed");
				}
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		delete.setHorizontalAlignment(SwingConstants.LEFT);
		delete.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-recycle-bin-50.png"));
		delete.setBounds(299, 287, 129, 54);
		contentPane.add(delete);
		contentPane.add(getScrollPane());
		displayData();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(280, 30, 603, 246);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int srow=table.getSelectedRow();
					id.setText(table.getValueAt(srow,0 ).toString());
					nametxt.setText(table.getValueAt(srow, 1).toString());
					number.setText(table.getValueAt(srow, 2).toString());
					addresstxt.setText(table.getValueAt(srow, 3).toString());
					email.setText(table.getValueAt(srow, 4).toString());
					password.setText(table.getValueAt(srow, 5).toString());
					addbtn.setEnabled(false);
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "Name", "Mobile", "Address", "Email", "Password"
				}
			));
		}
		return table;
	}
	private void displayData() {
		AdminPanel ap=new AdminPanelImpl();
		List<Cashier> clist=ap.getCashierData();
		DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		for(Cashier c:clist) {
			tmodel.addRow(new Object[] {
					c.getCuid(),c.getCuname(),c.getCunumber(),c.getCuaddress(),c.getCuemail(),c.getCupass()
			});
			
		}
		
		
	}
}
