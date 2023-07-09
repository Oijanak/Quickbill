package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddProductForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField productid;
	private JLabel lblNewLabel_1_1;
	private JTextField productname;
	private JLabel lblNewLabel_1_1_1;
	private JTextField productquantity;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField quantityadded;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JTextField mrp;
	private JButton addnewbtn;
	private JButton updateproductbtn;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductForm frame = new AddProductForm();
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
	public AddProductForm() {
		setBounds(100, 100, 753, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getProductid());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getProductname());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getProductquantity());
		contentPane.add(getLblNewLabel_1_1_1_1());
		contentPane.add(getQuantityadded());
		contentPane.add(getLblNewLabel_1_1_1_1_1());
		contentPane.add(getMrp());
		contentPane.add(getAddnewbtn());
		contentPane.add(getUpdateproductbtn());
		contentPane.add(getScrollPane());
		displayProductData();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Update Stock");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblNewLabel.setBounds(100, 11, 128, 20);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Product ID");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_1.setBounds(47, 76, 84, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getProductid() {
		if (productid == null) {
			productid = new JTextField();
			productid.setEditable(false);
			productid.setBounds(194, 73, 94, 20);
			productid.setColumns(10);
		}
		return productid;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Product Name");
			lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_1_1.setBounds(47, 118, 84, 14);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getProductname() {
		if (productname == null) {
			productname = new JTextField();
			productname.setColumns(10);
			productname.setBounds(194, 115, 94, 20);
		}
		return productname;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Quantity Available");
			lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_1_1_1.setBounds(47, 168, 110, 20);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getProductquantity() {
		if (productquantity == null) {
			productquantity = new JTextField();
			productquantity.setColumns(10);
			productquantity.setBounds(194, 168, 94, 20);
		}
		return productquantity;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Quantity Added");
			lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_1_1_1_1.setBounds(47, 214, 110, 20);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getQuantityadded() {
		if (quantityadded == null) {
			quantityadded = new JTextField();
			quantityadded.setEditable(false);
			quantityadded.setColumns(10);
			quantityadded.setBounds(194, 214, 94, 20);
		}
		return quantityadded;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("Mrp");
			lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblNewLabel_1_1_1_1_1.setBounds(47, 275, 110, 20);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JTextField getMrp() {
		if (mrp == null) {
			mrp = new JTextField();
			mrp.setColumns(10);
			mrp.setBounds(194, 275, 94, 20);
		}
		return mrp;
	}
	private JButton getAddnewbtn() {
		if (addnewbtn == null) {
			addnewbtn = new JButton("New");
			addnewbtn.setFont(new Font("Times New Roman", Font.BOLD, 12));
			addnewbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Product p=new Product();
					p.setPname(productname.getText());
					p.setPavailable(Integer.parseInt(productquantity.getText()));
					p.setPmrp(Integer.parseInt(mrp.getText()));
					ProductService ps=new ProductServiceImpl();
					if(ps.addProduct(p)) {
						JOptionPane.showMessageDialog(null, "Product Added");
						displayProductData();
						clearData();
					}
					else {
						JOptionPane.showMessageDialog(null, "Cannot be added");
					}
				}
			});
			addnewbtn.setBounds(47, 339, 89, 23);
		}
		return addnewbtn;
	}
	private JButton getUpdateproductbtn() {
		if (updateproductbtn == null) {
			updateproductbtn = new JButton("UPDATE");
			updateproductbtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
			updateproductbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select row first");
						return;
					}
					Product p=new Product();
					p.setPid(Integer.parseInt(productid.getText()));
					p.setPname(productname.getText());
					int added=Integer.parseInt(quantityadded.getText());
					int available=Integer.parseInt(productquantity.getText())+added;
					
					p.setPavailable(available);
					p.setPmrp(Integer.parseInt(mrp.getText()));
					ProductService ps=new ProductServiceImpl();
					if(ps.updateProduct(p)) {
						JOptionPane.showMessageDialog(null, "Updated");
						displayProductData();
						addnewbtn.setVisible(true);
						productquantity.setEditable(false);
						productid.setEditable(false);
						clearData();
					}
					else {
						JOptionPane.showMessageDialog(null, "Update failed");
					}
					
				}
			});
			updateproductbtn.setBounds(206, 339, 89, 23);
		}
		return updateproductbtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(320, 51, 407, 279);
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
					productid.setText(table.getValueAt(srow, 0).toString());
					productname.setText(table.getValueAt(srow, 1).toString());
					productquantity.setText(table.getValueAt(srow, 2).toString());
					mrp.setText(table.getValueAt(srow, 3).toString());
					addnewbtn.setVisible(false);
					quantityadded.setEditable(true);
					productid.setEditable(true);
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product id", "Product Name", "Product Available", "MRP"
				}
			));
		}
		return table;
	}
	void displayProductData() {
		ProductService ps=new ProductServiceImpl();
		List<Product> plist =ps.getAllProduct();
		DefaultTableModel tmodel=(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		for(Product p:plist) {
			tmodel.addRow(new Object[] {
					p.getPid(),p.getPname(),p.getPavailable(),p.getPmrp()
			});
		}
	}
	void clearData() {
		productid.setText(null);
		productname.setText(null);
		productquantity.setText(null);
		quantityadded.setText(null);
		mrp.setText(null);
	}
}
