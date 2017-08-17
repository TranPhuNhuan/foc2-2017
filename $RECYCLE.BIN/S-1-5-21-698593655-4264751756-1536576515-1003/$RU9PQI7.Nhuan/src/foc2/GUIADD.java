package foc2;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIADD extends JFrame {

	private JPanel contentPane;
	private SQLiteDB saleDb;
	private JTextField txtname;
	private JTextField txtunitprice;
	private JTextField txtunitinstock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIADD frame = new GUIADD();
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
	public GUIADD() {
		saleDb = new SQLiteDB();
		saleDb.getAllProducts();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProdeucts = new JLabel("ADD PRODEUCTS");
		lblAddProdeucts.setBounds(178, 11, 91, 14);
		contentPane.add(lblAddProdeucts);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 54, 46, 14);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(141, 51, 202, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblCategoryid = new JLabel("Categoryid");
		lblCategoryid.setBounds(10, 100, 68, 14);
		contentPane.add(lblCategoryid);
		
		JComboBox cmbcategoryid = new JComboBox();
		cmbcategoryid.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Category cat = (Category)cmbcategoryid.getSelectedItem();
				
			}
		});
		Vector<Category> catList = saleDb.getCategories();
		cmbcategoryid.setModel(new DefaultComboBoxModel(catList));
		cmbcategoryid.setBounds(145, 97, 198, 20);
		contentPane.add(cmbcategoryid);
		
		JLabel lblUnitprice = new JLabel("UnitPrice");
		lblUnitprice.setBounds(10, 143, 46, 14);
		contentPane.add(lblUnitprice);
		
		txtunitprice = new JTextField();
		txtunitprice.setBounds(141, 140, 202, 20);
		contentPane.add(txtunitprice);
		txtunitprice.setColumns(10);
		
		JLabel lblUnitinstock = new JLabel("UnitInStock");
		lblUnitinstock.setBounds(10, 184, 68, 14);
		contentPane.add(lblUnitinstock);
		
		txtunitinstock = new JTextField();
		txtunitinstock.setBounds(141, 181, 202, 20);
		contentPane.add(txtunitinstock);
		txtunitinstock.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = txtname.getText();
				double unitUnitPrice = Double.parseDouble(txtunitprice.getText());
				int unitInStock = Integer.parseInt(txtunitinstock.getText());
				Category selectedCat = (category)cmbCAtegory.getSelectedItem();
				int
			}
		});
		btnAdd.setBounds(81, 246, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(225, 246, 89, 23);
		contentPane.add(btnCancel);
	}
}
