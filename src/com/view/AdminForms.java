package com.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;

public class AdminForms extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForms frame = new AdminForms();
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
	public AdminForms() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Desktop\\quick.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 1002, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quick Bill");
		
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		ImageIcon ic1=new ImageIcon("C:\\Users\\Hp\\Desktop\\quick.png");
		Image img=ic1.getImage().getScaledInstance(80, 66, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 11, 208, 67);
		panel.add(lblNewLabel);
		
		JLabel cashierlbl = new JLabel("Cashier");
		cashierlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddCashierForm().setVisible(true);
				
				
			}
		});
		cashierlbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cashierlbl.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon ic2=new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\create.png");
		Image img1=ic2.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT);
		cashierlbl.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\cashier.png"));
		cashierlbl.setIconTextGap(-2);
		cashierlbl.setBounds(228, 11, 126, 58);
		panel.add(cashierlbl);
		
		JLabel transactionlbl = new JLabel("Transactions");
		transactionlbl.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-money-64.png"));
		transactionlbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		transactionlbl.setBounds(360, 11, 146, 58);
		transactionlbl.setIconTextGap(-2);
		panel.add(transactionlbl);
		
		JLabel stocklbl = new JLabel("Stock");
		stocklbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddProductForm().setVisible(true);
				
			}
		});
		stocklbl.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-warehouse-48.png"));
		stocklbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		stocklbl.setHorizontalAlignment(SwingConstants.CENTER);
		stocklbl.setBounds(508, 15, 117, 50);
		panel.add(stocklbl);
		
		JLabel saleslbl = new JLabel("Sales");
		saleslbl.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\icons8-money-bag-48.png"));
		saleslbl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		saleslbl.setBounds(646, 19, 97, 42);
		panel.add(saleslbl);
		
		JLabel exitlbl = new JLabel("EXIT");
		exitlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new WelcomeForm().setVisible(true);
				dispose();
			}
		});
		exitlbl.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\quick\\cancel.png"));
		exitlbl.setHorizontalAlignment(SwingConstants.CENTER);
		exitlbl.setFont(new Font("Sitka Text", Font.BOLD, 12));
		exitlbl.setBounds(895, 19, 97, 48);
		panel.add(exitlbl);
	}
}
