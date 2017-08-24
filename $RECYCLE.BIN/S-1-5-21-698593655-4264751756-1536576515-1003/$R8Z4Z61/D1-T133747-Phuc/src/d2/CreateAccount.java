package d2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel addAccountPanel = new JPanel();
		addAccountPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addAccountPanel, "AddAcountPane");
		addAccountPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel ButtonPane = new JPanel();
		ButtonPane.setPreferredSize(new Dimension(100, 40));
		ButtonPane.setBackground(SystemColor.activeCaption);
		addAccountPanel.add(ButtonPane, BorderLayout.SOUTH);
		ButtonPane.setLayout(null);
		
		JButton btnNext = new JButton("Next");
		
		btnNext.setBounds(148, 5, 76, 25);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtonPane.add(btnNext);
		
		JPanel accountInfoPanel = new JPanel();
		accountInfoPanel.setBackground(SystemColor.control);
		addAccountPanel.add(accountInfoPanel, BorderLayout.CENTER);
		accountInfoPanel.setLayout(null);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(42, 93, 167, 20);
		accountInfoPanel.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(219, 93, 105, 20);
		accountInfoPanel.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JTextPane txtpnFirstName = new JTextPane();
		txtpnFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnFirstName.setBackground(SystemColor.control);
		txtpnFirstName.setText("First name");
		txtpnFirstName.setBounds(42, 62, 80, 20);
		accountInfoPanel.add(txtpnFirstName);
		
		JTextPane txtpnLastName = new JTextPane();
		txtpnLastName.setBackground(SystemColor.control);
		txtpnLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnLastName.setText("Last Name");
		txtpnLastName.setBounds(219, 62, 65, 20);
		accountInfoPanel.add(txtpnLastName);
		
		JTextPane txtpnCreateYourAccount = new JTextPane();
		txtpnCreateYourAccount.setEditable(false);
		txtpnCreateYourAccount.setBackground(SystemColor.control);
		txtpnCreateYourAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnCreateYourAccount.setText("CREATE YOUR ACCOUNT");
		txtpnCreateYourAccount.setBounds(42, 11, 282, 40);
		accountInfoPanel.add(txtpnCreateYourAccount);
		
		JTextPane txtpnChooseYour = new JTextPane();
		txtpnChooseYour.setBackground(SystemColor.control);
		txtpnChooseYour.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnChooseYour.setText("Choose your username");
		txtpnChooseYour.setBounds(42, 124, 136, 20);
		accountInfoPanel.add(txtpnChooseYour);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(42, 144, 282, 20);
		accountInfoPanel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JTextPane txtpnChooseYourPassword = new JTextPane();
		txtpnChooseYourPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnChooseYourPassword.setBackground(SystemColor.control);
		txtpnChooseYourPassword.setText("Choose your password");
		txtpnChooseYourPassword.setBounds(42, 175, 167, 20);
		accountInfoPanel.add(txtpnChooseYourPassword);
		
		JTextPane txtpnConfirmYourPassword = new JTextPane();
		txtpnConfirmYourPassword.setBackground(SystemColor.control);
		txtpnConfirmYourPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnConfirmYourPassword.setText("Confirm your password");
		txtpnConfirmYourPassword.setBounds(42, 226, 136, 20);
		accountInfoPanel.add(txtpnConfirmYourPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 195, 282, 20);
		accountInfoPanel.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(42, 246, 282, 20);
		accountInfoPanel.add(passwordFieldConfirm);
		
		JTextPane txtpnBirthday = new JTextPane();
		txtpnBirthday.setBackground(SystemColor.control);
		txtpnBirthday.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnBirthday.setText("Birthday(d/m/y)");
		txtpnBirthday.setBounds(42, 277, 101, 20);
		accountInfoPanel.add(txtpnBirthday);
		
		textField = new JTextField();
		textField.setBounds(42, 300, 49, 20);
		accountInfoPanel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "Ferbuary", "March", "Arpil", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(101, 300, 77, 20);
		accountInfoPanel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 300, 136, 20);
		accountInfoPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setBackground(SystemColor.control);
		txtpnGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnGender.setText("Gender");
		txtpnGender.setBounds(42, 331, 49, 20);
		accountInfoPanel.add(txtpnGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(42, 350, 56, 23);
		accountInfoPanel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(100, 350, 78, 23);
		accountInfoPanel.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(175, 350, 109, 23);
		accountInfoPanel.add(rdbtnOther);
		
		JTextPane txtpnMobilePhone = new JTextPane();
		txtpnMobilePhone.setBackground(SystemColor.control);
		txtpnMobilePhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnMobilePhone.setText("Mobile Phone");
		txtpnMobilePhone.setBounds(42, 380, 86, 20);
		accountInfoPanel.add(txtpnMobilePhone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(42, 400, 282, 20);
		accountInfoPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxIArgee = new JCheckBox("I argee the terms of service");
		chckbxIArgee.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxIArgee.setBounds(46, 427, 183, 23);
		accountInfoPanel.add(chckbxIArgee);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel, "name_10910711518467");
		panel.setLayout(null);
		
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setBackground(Color.WHITE);
		txtpnWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnWelcome.setText("Welcome");
		txtpnWelcome.setBounds(147, 48, 73, 20);
		panel.add(txtpnWelcome);
		
		JTextPane txtpnThanksFor = new JTextPane();
		txtpnThanksFor.setEditable(false);
		txtpnThanksFor.setBackground(Color.WHITE);
		txtpnThanksFor.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnThanksFor.setText("Thanks for creating an account");
		txtpnThanksFor.setBounds(87, 283, 196, 20);
		panel.add(txtpnThanksFor);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CreateAccount.class.getResource("/images/index.png")));
		lblNewLabel.setBounds(87, 79, 179, 192);
		panel.add(lblNewLabel);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: kiem tra thong tin hop le
				
				//TODO: luu thong tin vao co so du lieu
				
				//TODO: chuyen den man hinh thong bao thanh cong
				CardLayout cards = (CardLayout)contentPane.getLayout();
				cards.next(contentPane);
				//cards.previous(contentPane);
			}
		});
	}
}
