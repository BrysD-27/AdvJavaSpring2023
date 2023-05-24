import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.GroupLayout.Alignment;

public class PersonGUI {
	public static void main(String [] args){
		createGUI();
	}
	static List<Person> pList = new ArrayList<Person>();
	
	private static File fileName;
	private static JTextArea textarea; 
	private static String text; 
	final static JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
	private static void createGUI() {
		JFrame frame = new JFrame("Person GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setResizable(false); 	
		
		Popup p;
		JLabel l = new JLabel("Save before exit?");
		JButton yesBtn = new JButton("Yes");
		JButton noBtn = new JButton("No");
		PopupFactory pf = new PopupFactory();
		JPanel p2 = new JPanel();
		p2.setBackground(Color.RED);
		p2.add(l);
		p2.add(yesBtn);
		p2.add(noBtn);
		noBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		yesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadToFile();
				System.exit(0);
			}
			
		});
		p = pf.getPopup(frame, p2, 260, 300);
		JButton addBtn = new JButton("Add");
		
		
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		JLabel govID = new JLabel("Government ID:");
		JLabel studentID = new JLabel("Student ID:");
		
		JTextField value_firstName = new JTextField(5);
		JTextField value_lastName = new JTextField(5);
		JTextField value_govID = new JTextField(5);
		JTextField value_studentID = new JTextField(5);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File"); 
		JMenuItem newBtn = new JMenuItem("New");
		JMenuItem openBtn = new JMenuItem("Open");
		openBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fc.setDialogTitle("Open file");
				fc.showOpenDialog(null);
			    fileName = fc.getSelectedFile();
			    System.out.println(fileName.getAbsolutePath());
			    openFile();
			}
			
		});
		JMenuItem saveBtn = new JMenuItem("Save");
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println("Save:" + fileName.getAbsolutePath());
				loadToFile();
			}
		});
		JMenuItem saveAsBtn = new JMenuItem("Save As");
		saveAsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fc.setDialogTitle("Save as");
				fc.showSaveDialog(null);
			    fileName = fc.getSelectedFile();
			    System.out.println("Save as:" + fileName.getAbsolutePath());
			    saveAsFile();	
			}
			
		});
		JMenu exitBtn = new JMenu("Exit");
		exitBtn.setMnemonic(KeyEvent.VK_X);
		exitBtn.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				p.show();
			}

			@Override
			public void menuDeselected(MenuEvent e) {

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				p.hide();
			}
		});
		menuBar.add(file);
		file.add(newBtn);
		file.add(openBtn);
		file.add(saveBtn);
		file.add(saveAsBtn);
		menuBar.add(exitBtn);
		frame.setJMenuBar(menuBar);
		
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(value_firstName.getText().isBlank() && value_lastName.getText().isBlank() && value_govID.getText().isBlank() && value_studentID.getText().isBlank()) {
					return;
				} else if (!value_govID.getText().isBlank() && !value_studentID.getText().isBlank()) {
  	        		pList.add(new OCCCPerson(value_firstName.getText(), value_lastName.getText(), value_govID.getText(), value_studentID.getText()));
				} else if (value_studentID.getText().isBlank() && !value_govID.getText().isBlank()) {
  	        		pList.add(new RegisteredPerson(value_firstName.getText(), value_lastName.getText(), value_govID.getText()));
				} else {
					pList.add(new Person(value_firstName.getText(), value_lastName.getText()));
				}
				updateList();
				value_firstName.setText("");
				value_lastName.setText("");
				value_govID.setText("");
				value_studentID.setText("");

			}
			
		});
		
		textarea = new JTextArea();

		JScrollPane scroll = new JScrollPane(textarea,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		Container container = frame.getContentPane();
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		
		layout.setHorizontalGroup(layout.createParallelGroup()
		
		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(firstName)
		.addGap(20)
		.addComponent(value_firstName)
		.addGap(50)
		.addComponent(lastName)
		.addGap(20)
		.addComponent(value_lastName)
		.addContainerGap())
	
		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(govID)
		.addGap(20)
		.addComponent(value_govID)
		.addGap(50)
		.addComponent(studentID)
		.addGap(20)
		.addComponent(value_studentID)
		.addContainerGap())
		
		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(addBtn))
	
		.addGroup(layout.createSequentialGroup()
		.addContainerGap()
		.addComponent(scroll)
		.addContainerGap()));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
		.addContainerGap()
	
		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(firstName)
		.addComponent(value_firstName)
		.addComponent(lastName)
		.addComponent(value_lastName))
		.addGap(20)
		
		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(govID)
		.addComponent(value_govID)
		.addComponent(studentID)
		.addComponent(value_studentID))
		.addGap(20)
		
		.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		.addComponent(addBtn))
		.addGap(20)
		
		.addComponent(scroll)
		.addContainerGap());

		frame.setVisible(true);
	}
	
	static void loadToFile() {
	    System.out.println("Dumping objects to " + fileName + "...");
	    if(pList.isEmpty()) {
	    	System.out.println("Exit without adding items...");
	    	return;
	    }
	    try{
	      FileOutputStream   fout = new FileOutputStream(fileName);
	      ObjectOutputStream oout = new ObjectOutputStream(fout);
	      oout.writeObject(pList);
	      System.out.println("Done");
	      fout.close();
	      oout.close();
	    }
	    catch(IOException e){
	      System.out.println("OH NO BAD THINGS HAPPEN");
	      System.out.println(e.toString());
	    }
  }
	
	static void saveAsFile() {
	    System.out.println("Dumping objects to " + fileName + "...");
	    if(pList.isEmpty()) {
	    	System.out.println("Exit without adding items...");
	    	return;
	    }
	    try{
	      FileOutputStream   fout = new FileOutputStream(fc.getSelectedFile() + ".txt");
	      ObjectOutputStream oout = new ObjectOutputStream(fout);
	      oout.writeObject(pList);
	      System.out.println("Done");
	      fout.close();
	      oout.close();
	    }
	    catch(IOException e){
	      System.out.println("OH NO BAD THINGS HAPPEN");
	      System.out.println(e.toString());
	    }
	}

	static void updateList() {
		for(int i = 0; i < pList.size(); i++) {
			Person p = pList.get(i);
			if(i == 0)
			text = p.getClass().toString() + " " + p.toString();
			else
				text = text + "\n" + p.getClass().toString() + " " + p.toString();
			textarea.setText(text);
		}
	}
	@SuppressWarnings("unchecked")
	static void openFile() {
		try {
			 
	        FileInputStream fileIn = new FileInputStream(fileName);
	        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	        pList = (ArrayList<Person>) objectIn.readObject();
	        Object obj = objectIn.readObject();
        	pList.add((Person) obj);
	        System.out.println("The Object has been read from the file" + obj.toString());
	        objectIn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		updateList();
	}
}
