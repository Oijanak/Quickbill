package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.AdminPanel;
import com.service.AdminPanelImpl;

import com.service.UserService;
import com.service.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField usernametxt;
	private JLabel lblNewLabel_1;
	private JButton cancelbtn;
	private JButton loginbtn;
	private JLabel clicklabel;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Desktop\\quick.png"));
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getUsernametxt());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getCancelbtn());
		contentPane.add(getLoginbtn());
		contentPane.add(getClicklabel());
		contentPane.add(getPasswordtxt());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Username:");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(78, 77, 83, 23);
		}
		return lblNewLabel;
	}
	private JTextField getUsernametxt() {
		if (usernametxt == null) {
			usernametxt = new JTextField();
			usernametxt.setBounds(178, 68, 131, 31);
			usernametxt.setColumns(10);
		}
		return usernametxt;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Passsword:");
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_1.setBounds(78, 146, 83, 23);
		}
		return lblNewLabel_1;
	}
	private JButton getCancelbtn() {
		if (cancelbtn == null) {
			cancelbtn = new JButton("Cancel");
			cancelbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new WelcomeForm().setVisible(true);
					dispose();
				}
			});
			cancelbtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
			cancelbtn.setBackground(new Color(255, 0, 0));
			cancelbtn.setForeground(new Color(255, 255, 255));
			cancelbtn.setBounds(76, 191, 85, 31);
		}
		return cancelbtn;
	}
	private JButton getLoginbtn() {
		if (loginbtn == null) {
			loginbtn = new JButton("Login");
			loginbtn.setForeground(new Color(0, 0, 0));
			loginbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String uname=usernametxt.getText();
					String pass=passwordtxt.getText();
					
					
					UserService as=new UserServiceImpl();
					if(as.verifyAdmin(uname, pass)) {
						JOptionPane.showMessageDialog(null,"Login success");
						new AdminForms().setVisible(true);
						dispose();
					}
					else if(as.verifycashier(uname, pass)) {
						JOptionPane.showMessageDialog(null,"Login success");
						new CashierForms().setVisible(true);
						dispose();
					}
					
					
					else {
						JOptionPane.showMessageDialog(null, "Username or password doesnt match");
					}
				}
			});
			loginbtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
			loginbtn.setBounds(201, 191, 85, 31);
		}
		return loginbtn;
	}
	private JLabel getClicklabel() {
		if (clicklabel == null) {
			clicklabel = new JLabel("click here to create new account");
			clicklabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new RegisterForm().setVisible(true);
					dispose();
					
				}
			});
			clicklabel.setHorizontalAlignment(SwingConstants.CENTER);
			clicklabel.setFont(new Font("Sitka Banner", Font.ITALIC, 20));
			clicklabel.setBounds(128, 255, 258, 23);
		}
		return clicklabel;
	}
	private JPasswordField getPasswordtxt() {
		if (passwordtxt == null) {
			passwordtxt = new JPasswordField();
			passwordtxt.setBounds(176, 137, 131, 31);
		}
		return passwordtxt;
	}
}
