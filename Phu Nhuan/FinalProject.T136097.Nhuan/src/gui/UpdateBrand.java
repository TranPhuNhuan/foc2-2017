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
import dataobject.Product;
import dataobject.UnitOfMeasure;

@SuppressWarnings("unused")
public class UpdateBrand extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBrandname;
	private JTextField txtDescription;
	
	//private ProductDA productDA;
	private BrandDA brandDA;
	//private BrandDA brandDA;
	//private UnitOfMeasureDA unitDA;
	
	private JButton btnUpdate;
	private JButton btnCancel;

	public int brandID = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBrand frame = new UpdateBrand(1);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param selectedProductID 
	 */
	public UpdateBrand(int bid) {
		brandID = bid;
		//productDA = new ProductDA();
		brandDA = new BrandDA();
		//brandDA = new BrandDA();
		//unitDA = new UnitOfMeasureDA();
		
		initGUI();
		
		
		Brand b = brandDA.getBrand(brandID);
		txtBrandname.setText(b.getBrandName());
		txtDescription.setText(b.getBrandDescription());
		
		
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Update Brand - Nhuan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBrandName.setBounds(26, 105, 102, 20);
		contentPane.add(lblBrandName);
		
		txtBrandname = new JTextField();
		txtBrandname.setBounds(138, 107, 173, 20);
		contentPane.add(txtBrandname);
		txtBrandname.setColumns(10);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDescription.setBounds(26, 171, 89, 14);
		contentPane.add(lbDescription);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(138, 170, 173, 20);
		contentPane.add(txtDescription);
		
		JLabel lblUpdateBrand = new JLabel("Update Brand");
		lblUpdateBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBrand.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateBrand.setBounds(56, 27, 230, 30);
		contentPane.add(lblUpdateBrand);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(56, 241, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(180, 241, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		//Vector<Category> catList = catDA.getAllCategories();
		//Vector<UnitOfMeasure>unitList = unitDA.getUnitOfMeasure();
		//Vector<Brand> brandList = brandDA.getBrands();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpdate){
			updateCategory();
			brandDA.getBrands();
			JOptionPane.showMessageDialog(this,"updated completed");
			
			BrandList frame1 = new BrandList();
			frame1.setVisible(true);
		}else if(e.getSource() == btnCancel){
			UpdateBrand.this.dispose();
		}
		
	}

	private void updateCategory() {
		String brandName = txtBrandname.getText();
		String brandDescription = txtDescription.getText();
		
		brandDA.update(brandName, brandDescription, brandID);
	}
}
