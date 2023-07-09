package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class WelcomeForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton adminbtn;
	private JButton cashierbtn;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeForm frame = new WelcomeForm();
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
	public WelcomeForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Desktop\\quick.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setForeground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getAdminbtn());
		contentPane.add(getCashierbtn());
		contentPane.add(getLblNewLabel_1());
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon ic1=new ImageIcon("C:\\Users\\Hp\\Desktop\\quick.png");
		Image img=ic1.getImage().getScaledInstance(160, 150, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(174, 106, 174, 162);
		contentPane.add(lblNewLabel_3);
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome To Super Market Billing System");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblNewLabel.setBounds(125, 33, 557, 47);
		}
		return lblNewLabel;
	}
	private JButton getAdminbtn() {
		if (adminbtn == null) {
			adminbtn = new JButton("Admin Login");
			adminbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			adminbtn.setFont(new Font("Serif", Font.BOLD, 15));
			adminbtn.setBounds(603, 151, 153, 30);
		}
		return adminbtn;
	}
	private JButton getCashierbtn() {
		if (cashierbtn == null) {
			cashierbtn = new JButton("Cashier Login");
			cashierbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			cashierbtn.setFont(new Font("Serif", Font.BOLD, 15));
			cashierbtn.setBounds(603, 253, 153, 30);
		}
		return cashierbtn;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Quick Bill");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 40));
			lblNewLabel_1.setBounds(150, 268, 234, 54);
		}
		return lblNewLabel_1;
	}
}
