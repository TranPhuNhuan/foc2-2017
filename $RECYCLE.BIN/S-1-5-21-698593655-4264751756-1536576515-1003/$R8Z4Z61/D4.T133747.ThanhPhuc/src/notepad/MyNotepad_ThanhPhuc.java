package notepad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyNotepad_ThanhPhuc extends JFrame {
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat, mnuTools;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor, mniAnalyze;
	
	JTextArea txaContent;
	JScrollPane scrPane;
	
	public MyNotepad_ThanhPhuc () {
		setTitle("MyNotepad_ThanhPhuc");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		initializeMenu();
		txaContent = new JTextArea();
		scrPane = new JScrollPane(txaContent);
		getContentPane().add(scrPane);

		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==mniOpen){
					openFile();
				}
				else if (e.getSource()==mniExit){
					closeApplication();
				}
				else if (e.getSource()==mniChangeBgColor){
					changeBGcolor();
				}
				else if (e.getSource()==mniChangeFontColor){
					changeFontColor();
				}
				else if (e.getSource()==mniAnalyze){
					
					//cach 1
					//for(String line : txaContent.getText().split("\r\n")){
						//System.out.println(line);
					//}
					
					//cach 2
					int count7=0, count45=0,countSV=0;
					double min1 = 10, min =10 ;
					double max = 0;
					int focmax = 0;
					String[] lines = txaContent.getText().split("\r\n");
					String fnlsmin1=null;
					String fnlsmin2=null;
					String fnlsnmax=null;
					String diemfocmax = null;
					DecimalFormat scoreFormat = new DecimalFormat("#0.00");
					for(int i=1; i< lines.length; i++){
						//System.out.println(lines[i]);
						String[]fields = lines[i].split(",");
						if(fields.length == 7){
							String stt = fields[0];
							String sid = fields[1];
							String lastname = fields[2];
							String firstname = fields[3];
							
							int foc = Integer.parseInt(fields[4]);
							int network = Integer.parseInt(fields[5]);
							int adp = Integer.parseInt(fields[6]);
							
							countSV++;
							double average = (foc+network+adp)*1.0/3;
							//scoreFormat.format(average);
							
							if(average >= 7){
								count7++;
							};
							if(average <= 4.5){
								count45++;
							}
							
							if(average < min1){
								min1 = average;
								fnlsmin1 = fields[2]+fields[3];
								
							}
							
							if(average < min){
								min = average;
								//fnlsmin2 = fields[2]+fields[3];
							}
							if(min1 == min && min == average){
								fnlsmin2 = fields[2]+fields[3];
							}
							if(average > max){
								max = average;
								fnlsnmax = fields[2]+fields[3];
							}
							
							if( foc > focmax){
								focmax= foc;
								diemfocmax = fields[2]+fields[3];
								
							}
						}
					} 
					String message ="Tong so sinh vien: " +countSV+"\n";
					message +="So sinh vien co diem trung binh tren 7: " +count7+"\n";
					message +="So sinh vien co diem trung binh nho hon hoac bang 4.5: " +count45+"\n";
					message +="Sinh vien co diem trung binh thap nhat: " +min1 + " "+ fnlsmin1 + " va " + fnlsmin2+"\n";
					message +="Sinh vien co diem trung binh cao nhat: " +max + " "+ fnlsnmax+"\n";
					message +="diem foc cao nhat la: " + focmax + " Ho ten" + diemfocmax+"\n";
					JOptionPane.showMessageDialog(MyNotepad_ThanhPhuc.this, message);
					
				}
			}
		};
		
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);
		mniAnalyze.addActionListener(action);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				closeApplication();
			}
		});
	}
	
	public void initializeMenu(){
		mnbBar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mnuTools = new JMenu("Tools");
		
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniChangeBgColor = new JMenuItem("Change BG color");
		mniChangeFontColor = new JMenuItem("Change font color");
		mniAnalyze = new JMenuItem("Analyze");
		
		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		
		mnuFormat.add(mniChangeBgColor);
		mnuFormat.add(mniChangeFontColor);
		
		mnuTools.add(mniAnalyze);
		
		mnbBar.add(mnuFile);
		mnbBar.add(mnuFormat);
		mnbBar.add(mnuTools);
		
		setJMenuBar(mnbBar);
	}
	
	public void openFile(){
		JFileChooser fchOpenFile = new JFileChooser();
		int result = fchOpenFile.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			try{
				Scanner scn = new Scanner(fchOpenFile.getSelectedFile());
				while(scn.hasNextLine()){
					txaContent.append(scn.nextLine() + "\r\n");
				}
				scn.close();
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Selected file not found");
			}
		}
	}
	
	
	public void changeBGcolor(){
		Color newColor = JColorChooser.showDialog(this, "Choose new background color", txaContent.getBackground());
		txaContent.setBackground(newColor);
	}
	
	public void changeFontColor(){
		Color newColor = JColorChooser.showDialog(this, "Choose new font color", txaContent.getForeground());
		txaContent.setForeground(newColor);
	}
	
	public void closeApplication(){
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", 
				"Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(result == JOptionPane.YES_OPTION){
			System.exit(0);
		}
				
	}
	
	
	public static void main(String[] args) {
		MyNotepad_ThanhPhuc f = new MyNotepad_ThanhPhuc();
		f.setVisible(true);
		
	}
}
	
