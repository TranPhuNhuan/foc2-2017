/**
 * 
 */
package notepad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
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

/**
 * @author US
 *
 */
public class MyNotePad_Nhuan extends JFrame {

	/**
	 * @param args
	 */
	private static final ActionListener Analyze = null;
	JMenuBar mnbBar;
	JMenu mnuFile, mnuFormat, mnuTools;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor, mniAnalyze;

	JTextArea txaContent;
	JScrollPane scrPane;

	public MyNotePad_Nhuan() {
		setTitle("MyNotePad");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
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
					closeApplication();
					String[] lines = textArea.getText().split("\r\n");
					for(int i=1; i<lines.length; i++){
						//System.out.println(lines[i]);
						String[] fields = lines[i].split(",");
						if(fields.length == 7){
							String stt = fields[0];
							String sid = fields[1];
							String lastName = fields[2];
							String firstName= fields[3];
							int foc = Integer.parseInt(fields[4]);
							int introNW= Integer.parseInt(fields[5]);
							int adp = Integer.parseInt(fields[6]);
							// tinh diem trung binh
							double average = (foc + introNW + adp) * 1.0 / 3;
							
							
							DecimalFormat scoreFormat = new DecimalFormat("#0.00");
							System.out.println(scoreFormat.format(average));
							
						}
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
					txaContent.append(scn.nextLine() + "\n");
				}
				scn.close();
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Selected file not found");
			}
		}
	}
	
	public static void main(String[] args ) {
		// TODO Auto-generated method stub
		MyNotePad_Nhuan f = new MyNotePad_Nhuan();
		f.setVisible(true);
	}

}
}
