package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.model.Admin;
import com.service.AdminPanel;
import com.service.AdminPanelImpl;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField fName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblBirthdate;
	private JLabel lblAddress;
	private JTextField lname;
	private JTextField uname;
	private JPasswordField pass;
	private JPasswordField repass;
	private JTextField address;
	private JButton cancelregister;
	private JButton btnNewButton_1;
	private JLabel clickloginlabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Desktop\\quick.png"));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 537);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getFName());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getLblRetypePassword());
		contentPane.add(getLblBirthdate());
		contentPane.add(getLblAddress());
		contentPane.add(getLname());
		contentPane.add(getUname());
		contentPane.add(getPass());
		contentPane.add(getRepass());
		contentPane.add(getAddress());
		contentPane.add(getCancelregister());
		
		contentPane.add(getClickloginlabel());
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 268, 154, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a=new Admin();
				
				a.setFirstName(getFName().getText());
				a.setLastName(getLname().getText());
				a.setAddress(getAddress().getText());
				a.setAdminusername(getUname().getText());
				a.setAdminpassword(getPass().getText());
				
				
				a.setBirthdate(dateChooser.getDate().toString());
				String retype=getRepass().getText();
				
				
				if(retype.equals(a.getAdminpassword())) {
					AdminPanel as=new AdminPanelImpl();
					if(as.registerAdmin(a)) {
						JOptionPane.showMessageDialog(null, "Registered");
						new LoginForm().setVisible(true);
						dispose();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Password doesnt match");
					return;
					}
				}
			
				
				
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(224, 383, 96, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("First Name:");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(89, 34, 88, 20);
		}
		return lblNewLabel;
	}
	private JTextField getFName() {
		if (fName == null) {
			fName = new JTextField();
			fName.setBounds(187, 34, 152, 21);
			fName.setColumns(10);
		}
		return fName;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name:");
			lblLastName.setForeground(Color.WHITE);
			lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblLastName.setBounds(89, 84, 88, 20);
		}
		return lblLastName;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblUsername.setBounds(89, 127, 88, 20);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblPassword.setBounds(89, 173, 88, 20);
		}
		return lblPassword;
	}
	private JLabel getLblRetypePassword() {
		if (lblRetypePassword == null) {
			lblRetypePassword = new JLabel("Retype Password:");
			lblRetypePassword.setForeground(Color.WHITE);
			lblRetypePassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblRetypePassword.setBounds(59, 218, 118, 20);
		}
		return lblRetypePassword;
	}
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("BirthDate:");
			lblBirthdate.setForeground(Color.WHITE);
			lblBirthdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblBirthdate.setBounds(89, 268, 88, 20);
		}
		return lblBirthdate;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(Color.WHITE);
			lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblAddress.setBounds(89, 328, 88, 20);
		}
		return lblAddress;
	}
	private JTextField getLname() {
		if (lname == null) {
			lname = new JTextField();
			lname.setBounds(187, 86, 152, 19);
			lname.setColumns(10);
		}
		return lname;
	}
	private JTextField getUname() {
		if (uname == null) {
			uname = new JTextField();
			uname.setColumns(10);
			uname.setBounds(187, 129, 152, 21);
		}
		return uname;
	}
	private JPasswordField getPass() {
		if (pass == null) {
			pass = new JPasswordField();
			pass.setBounds(187, 173, 152, 21);
		}
		return pass;
	}
	private JPasswordField getRepass() {
		if (repass == null) {
			repass = new JPasswordField();
			repass.setBounds(187, 220, 152, 21);
		}
		return repass;
	}
	private JTextField getAddress() {
		if (address == null) {
			address = new JTextField();
			address.setBounds(187, 330, 152, 19);
			address.setColumns(10);
		}
		return address;
	}
	private JButton getCancelregister() {
		if (cancelregister == null) {
			cancelregister = new JButton("Cancel");
			cancelregister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			cancelregister.setFont(new Font("Times New Roman", Font.BOLD, 15));
			cancelregister.setForeground(new Color(255, 255, 255));
			cancelregister.setBackground(new Color(128, 0, 0));
			cancelregister.setBounds(92, 383, 85, 29);
		}
		return cancelregister;
	}
	
	private JLabel getClickloginlabel() {
		if (clickloginlabel == null) {
			clickloginlabel = new JLabel("click here to login");
			clickloginlabel.setForeground(new Color(255, 255, 255));
			clickloginlabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			clickloginlabel.setHorizontalAlignment(SwingConstants.CENTER);
			clickloginlabel.setFont(new Font("Sitka Small", Font.ITALIC, 20));
			clickloginlabel.setBounds(208, 434, 202, 29);
		}
		return clickloginlabel;
	}
}
