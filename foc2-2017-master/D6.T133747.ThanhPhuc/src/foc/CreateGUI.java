package foc;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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


public class CreateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private SQLiteDB salesDb;
	private JTextField textFieldPrice;
	private JTextField textFieldInStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI frame = new CreateGUI();
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
	public CreateGUI() {
		setType(Type.UTILITY);
		
		salesDb = new SQLiteDB();
		salesDb.getAllCategories();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddProduct.setBounds(149, 18, 111, 14);
		contentPane.add(lblAddProduct);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(25, 46, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(107, 43, 216, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoryid");
		lblNewLabel_1.setBounds(25, 77, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//System.out.println(comboBox.getSelectedItem());
				Category cat = (Category)comboBox.getSelectedItem();
				
			}
		});
		
		Vector<Category> catList = salesDb.getAllCategories();
		comboBox.setModel(new DefaultComboBoxModel(catList));
		
		comboBox.setBounds(107, 74, 216, 20);
		contentPane.add(comboBox);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(25, 115, 46, 14);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(107, 105, 216, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel lblInstock = new JLabel("InStock");
		lblInstock.setBounds(25, 140, 46, 14);
		contentPane.add(lblInstock);
		
		textFieldInStock = new JTextField();
		textFieldInStock.setBounds(107, 137, 216, 20);
		contentPane.add(textFieldInStock);
		textFieldInStock.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productname = textFieldName.getText();
				double unitUnitprice = Double.parseDouble(textFieldPrice.getText());
				int unitStock = Integer.parseInt(textFieldInStock.getText());
				Category selectedCat = (Category) comboBox.getSelectedItem();
				int catId = selectedCat.getCategoryId();
				
				salesDb.insert(productname, catId, unitUnitprice, unitStock);
				salesDb.getAllProducts();
			}
		});
		btnOk.setBounds(75, 205, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(234, 205, 89, 23);
		contentPane.add(btnCancel);
	}
}
