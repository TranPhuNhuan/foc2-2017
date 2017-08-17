package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import da.SQLiteDB;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.util.Vector;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private SQLiteDB foc2warehouse;
	private JTextField txtProductCode;
	private JTextField txtUnitPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setType(Type.UTILITY);
		
		foc2warehouse = new SQLiteDB();
		foc2warehouse.getAllCategories();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 382);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddProduct.setBounds(149, 18, 111, 14);
		contentPane.add(lblAddProduct);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 104, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(157, 101, 216, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoryid");
		lblNewLabel_1.setBounds(25, 135, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cmbCategoryid = new JComboBox();
		cmbCategoryid.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//System.out.println(comboBox.getSelectedItem());
				Category cat = (Category)cmbCategoryid.getSelectedItem();
				
			}
		});
		
		Vector<Category> catList = foc2warehouse.getAllCategories();
		cmbCategoryid.setModel(new DefaultComboBoxModel(catList));
		cmbCategoryid.setBounds(157, 132, 216, 20);
		contentPane.add(cmbCategoryid);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(25, 201, 69, 14);
		contentPane.add(lblBrand);
		
		JLabel lblInstock = new JLabel("Product Code");
		lblInstock.setBounds(25, 73, 86, 14);
		contentPane.add(lblInstock);
		
		txtProductCode = new JTextField();
		txtProductCode.setBounds(157, 70, 216, 20);
		contentPane.add(txtProductCode);
		txtProductCode.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productname = txtName.getText();
				double unitUnitprice = Double.parseDouble(txtUnitPrice.getText());
				int unitStock = Integer.parseInt(txtProductCode.getText());
				Category selectedCat = (Category) cmbCategoryid.getSelectedItem();
				int catId = selectedCat.getCategoryId();
				
//				foc2warehouse.insert(productname, catId, unitUnitprice, unitStock);
//				foc2warehouse.getAllProducts();
			}
		});
		btnOk.setBounds(81, 288, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(241, 288, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblUnitOfMeasure = new JLabel("Unit of Measure");
		lblUnitOfMeasure.setBounds(25, 170, 98, 14);
		contentPane.add(lblUnitOfMeasure);
		
		JComboBox cmbUniofMeasure = new JComboBox();
		cmbUniofMeasure.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		
		Vector<UnitOfMeasure> unitofmeasureList = foc2warehouse.getAllUnitofmeasure();
		cmbUniofMeasure.setModel(new DefaultComboBoxModel(unitofmeasureList));
		
		cmbUniofMeasure.setBounds(157, 167, 216, 20);
		contentPane.add(cmbUniofMeasure);
		
		JLabel lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setBounds(25, 233, 69, 14);
		contentPane.add(lblUnitPrice);
		
		txtUnitPrice = new JTextField();
		txtUnitPrice.setBounds(157, 229, 216, 20);
		contentPane.add(txtUnitPrice);
		txtUnitPrice.setColumns(10);
		
		JComboBox cmbBrand = new JComboBox();
		cmbBrand.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		Vector<Brand> brandList = foc2warehouse.getAllBrand();
		cmbBrand.setModel(new DefaultComboBoxModel(brandList));
		cmbBrand.setBounds(157, 198, 216, 20);
		contentPane.add(cmbBrand);
	}
}