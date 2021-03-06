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
public class UpdateCategory extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCategoryName;
	private JTextField txtDescription;
	
	//private ProductDA productDA;
	private CategoryDA catDA;
	//private BrandDA brandDA;
	//private UnitOfMeasureDA unitDA;
	
	private JButton btnUpdate;
	private JButton btnCancel;

	public int categoryID = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCategory frame = new UpdateCategory(1);
					
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
	public UpdateCategory(int cid) {
		categoryID = cid;
		//productDA = new ProductDA();
		catDA = new CategoryDA();
		//brandDA = new BrandDA();
		//unitDA = new UnitOfMeasureDA();
		
		initGUI();
		
		
		Category c = catDA.getCategory(categoryID);
		txtCategoryName.setText(c.getCategoryName());
		txtDescription.setText(c.getCategoryDescription());
		
		
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Update Category - Nhuan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoryName.setBounds(26, 105, 102, 20);
		contentPane.add(lblCategoryName);
		
		txtCategoryName = new JTextField();
		txtCategoryName.setBounds(138, 107, 173, 20);
		contentPane.add(txtCategoryName);
		txtCategoryName.setColumns(10);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDescription.setBounds(26, 171, 89, 14);
		contentPane.add(lbDescription);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(138, 170, 173, 20);
		contentPane.add(txtDescription);
		
		JLabel lblUpdateCategory = new JLabel("Update Category");
		lblUpdateCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateCategory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateCategory.setBounds(56, 27, 230, 30);
		contentPane.add(lblUpdateCategory);
		
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
			catDA.getAllCategories();
			JOptionPane.showMessageDialog(this,"updated completed");
			
			CategoryList frame1 = new CategoryList();
			frame1.setVisible(true);
		}else if(e.getSource() == btnCancel){
			UpdateCategory.this.dispose();
		}
		
	}

	private void updateCategory() {
		String categoryName = txtCategoryName.getText();
		String categoryDescription = txtDescription.getText();
		
		catDA.update(categoryName, categoryDescription, categoryID);
	}
}
