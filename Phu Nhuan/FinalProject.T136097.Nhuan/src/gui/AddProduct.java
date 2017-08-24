package gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

@SuppressWarnings("unused")
public class AddProduct extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUnitprice;
	private JTextField txtProductcode;
	
	private ProductDA productDA;
	private CategoryDA catDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitDA;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox<Category> cmbCategory;
	private JComboBox<UnitOfMeasure> cmbUnitofmeasure;
	private JComboBox<Brand> cmbBrand;

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
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitOfMeasureDA();
		
		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Add Product - Nhuan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 102, 74, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(137, 99, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(25, 133, 74, 14);
		contentPane.add(lblCategory);
		
		JLabel lblUnitprice = new JLabel("Unit Price");
		lblUnitprice.setBounds(25, 222, 74, 14);
		contentPane.add(lblUnitprice);
		
		txtUnitprice = new JTextField();
		txtUnitprice.setColumns(10);
		txtUnitprice.setBounds(137, 219, 173, 20);
		contentPane.add(txtUnitprice);
		
		JLabel lbProductcode = new JLabel("Product Code");
		lbProductcode.setBounds(25, 71, 74, 14);
		contentPane.add(lbProductcode);
		
		txtProductcode = new JTextField();
		txtProductcode.setColumns(10);
		txtProductcode.setBounds(137, 68, 173, 20);
		contentPane.add(txtProductcode);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddProduct.setBounds(39, 27, 229, 14);
		contentPane.add(lblAddProduct);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(61, 272, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(179, 272, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		
		cmbCategory = new JComboBox<Category>();
		Vector<Category> catList = catDA.getAllCategories();
		cmbCategory.setModel(new DefaultComboBoxModel<Category>(catList));
		cmbCategory.setBounds(137, 130, 173, 20);
		contentPane.add(cmbCategory);
		
		JLabel lblUnitOfMeasre = new JLabel("Unit of Measure");
		lblUnitOfMeasre.setBounds(25, 164, 102, 14);
		contentPane.add(lblUnitOfMeasre);
		
		cmbUnitofmeasure = new JComboBox<UnitOfMeasure>();
		Vector<UnitOfMeasure>unitList = unitDA.getUnitOfMeasure();
		cmbUnitofmeasure.setModel(new DefaultComboBoxModel<UnitOfMeasure>(unitList));
		cmbUnitofmeasure.setBounds(137, 161, 173, 20);
		contentPane.add(cmbUnitofmeasure);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(25, 192, 74, 14);
		contentPane.add(lblBrand);
		
		cmbBrand = new JComboBox<Brand>();
		Vector<Brand> brandList = brandDA.getBrands();
		cmbBrand.setModel(new DefaultComboBoxModel<Brand>(brandList));
		cmbBrand.setBounds(137, 189, 173, 20);
		contentPane.add(cmbBrand);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			addProduct();
			productDA.getAllProducts();
			JOptionPane.showMessageDialog(this,"add completed");
			
			ProductList frame1 = new ProductList();
			frame1.setVisible(true);
			
		}else if(e.getSource() == btnCancel){
			AddProduct.this.dispose();
		}
		
	}

	private void addProduct() {
		String productCode = txtProductcode.getText();
		String productName = txtName.getText();
		double unitPrice = Double.parseDouble(txtUnitprice.getText());
		Category selectedCat = (Category)cmbCategory.getSelectedItem();
		Brand selectedBrand = (Brand)cmbBrand.getSelectedItem();
		UnitOfMeasure selectedUnit = (UnitOfMeasure)cmbUnitofmeasure.getSelectedItem();
		int catId = selectedCat.getCategoryId();
		int brandId = selectedBrand.getBrandId();
		int unitId = selectedUnit.getId();
		
		productDA.insert(productCode, productName, catId, brandId, unitId, unitPrice, "");
		
	}
}
