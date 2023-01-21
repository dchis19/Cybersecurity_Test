import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.Timer;
import java.io.*;

/**
* The RegistrationPage class renders the Registration page for the user. The user inputs their information which will
* be used later on for file directories and tracking their final score.
* 
* Pre-condition: EDIPI, Rank, Last Name, First Name, Unit, and Test Type
* 
* Post-Condition: User clicks next and the MyFrame class is called to show quiz questions
* 
* @author Daniel Chisner
*/


public class RegistrationPage extends JFrame implements ActionListener{
	JTextField textField, textField1, textField2, textField3, textField4;
	JButton button;
	Timer timer;
	Write write = new Write();
	JRadioButton netPlusButton, secPlusButton, cehButton, dataCourseButton;
	JPanel errorMessagePanel;
	JLabel firstErrorMessage;
	int questionCounter = 1, correctAnswerCounter = 0;

	public void registrationPage(){

		ImageIcon image = new ImageIcon("MACG28Logo.png");
		ImageIcon image1 = new ImageIcon("MWCS28Logo.png");
		JLabel label = new JLabel();
		JLabel macgLogo = new JLabel();
		JLabel mwcsLogo = new JLabel();
		this.add(label);
		label.setText("MWCS-28 Testing Center"); //Set set text of label
		label.setHorizontalTextPosition(JLabel.RIGHT);//Set text left, right, right of image
		label.setVerticalTextPosition(JLabel.CENTER); //Set text TOP, CENTER, BOTTOM
		label.setForeground(new Color(0, 0, 0)); //Set color of text
		label.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label.setVerticalAlignment(JLabel.CENTER); //set location of the label to top
		label.setHorizontalAlignment(JLabel.CENTER); //Set location of label to center
		this.setLayout(null);
		label.setBackground(new Color(100, 100, 100));
		label.setOpaque(true);
		label.setBounds(175, 0, 675, 100);

		this.add(macgLogo); //Add MACG-28 logo to top left
		macgLogo.setIcon(image);
		macgLogo.setHorizontalAlignment(JLabel.CENTER);
		macgLogo.setVerticalAlignment(JLabel.TOP);
		macgLogo.setBackground(new Color(100, 100, 100));
		macgLogo.setOpaque(true);
		macgLogo.setBounds(0, 0, 200, 100);

		this.add(mwcsLogo); //Add MWCS-28 logo to top right
		mwcsLogo.setIcon(image1);
		mwcsLogo.setHorizontalAlignment(JLabel.LEFT);
		mwcsLogo.setVerticalAlignment(JLabel.TOP);
		mwcsLogo.setBackground(new Color(100, 100, 100));
		mwcsLogo.setOpaque(true);
		mwcsLogo.setBounds(840, 0, 1000, 100);
		this.add(label);

		JPanel panel = new JPanel(); //sets the panel into 5 rows and 2 columns
		panel.setBackground(new Color(175, 175, 175));
		panel.setBounds(100, 150, 800, 300);
		panel.setLayout(new GridLayout(5,2));

		JLabel label1 = new JLabel(); //EDIPI label on left hand side
		label1.setText("EDIPI:"); //Set set text of label
		label1.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		panel.add(label1);

		textField = new JTextField(); //Textfield to enter EDIPI
		textField.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		textField.setEditable(true);
		textField.setPreferredSize(new Dimension(50,1));
		panel.add(textField);

		JLabel label5 = new JLabel(); //Rank label on left hand side
		label5.setText("RANK:"); //Set set text of label
		label5.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label5.setHorizontalAlignment(JLabel.CENTER);
		label5.setVerticalAlignment(JLabel.CENTER);
		panel.add(label5);

		textField1 = new JTextField(); //Textfield to enter Rank
		textField1.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		textField1.setEditable(true);
		textField1.setPreferredSize(new Dimension(50,1));
		panel.add(textField1);

		JLabel label2 = new JLabel(); //Last Name label on left hand side
		label2.setText("LAST NAME:"); //Set set text of label
		label2.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.CENTER);
		panel.add(label2);

		textField2 = new JTextField(); //Textfield to enter Last Name
		textField2.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		textField2.setEditable(true);
		panel.add(textField2);

		JLabel label3 = new JLabel(); //First Name label on left hand side
		label3.setText("FIRST NAME:"); //Set set text of label
		label3.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setVerticalAlignment(JLabel.CENTER);
		panel.add(label3);

		textField3 = new JTextField(); //Textfield to enter First Name
		textField3.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		textField3.setEditable(true);
		panel.add(textField3);

		JLabel label4 = new JLabel(); //Unit/Company label on left hand side
		label4.setText("UNIT/COMPANY:"); //Set set text of label
		label4.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setVerticalAlignment(JLabel.CENTER);
		panel.add(label4);

		textField4 = new JTextField(); //Textfield to enter Unit/Company
		textField4.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		textField4.setEditable(true);
		panel.add(textField4);

		JPanel panelCheckboxTitle = new JPanel(); //Checkboxes panel/background
		panelCheckboxTitle.setBackground(new Color(175, 175, 175));
		panelCheckboxTitle.setBounds(50, 500, 900, 50);
		JLabel label4panelCheck = new JLabel();
		label4panelCheck.setText("SELECT TEST"); //Set set text of label
		label4panelCheck.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label4panelCheck.setHorizontalAlignment(JLabel.CENTER);
		label4panelCheck.setVerticalAlignment(JLabel.CENTER);
		panelCheckboxTitle.add(label4panelCheck);

		JPanel panelCheckBox = new JPanel();
		panelCheckBox.setBackground(new Color(220, 220, 220));
		panelCheckBox.setBounds(50, 550, 900, 50);
		panelCheckBox.setLayout(new GridLayout(1,4));

		netPlusButton = new JRadioButton();
		secPlusButton = new JRadioButton();
		cehButton = new JRadioButton();
		dataCourseButton = new JRadioButton();

		netPlusButton.setText("Network+");
		netPlusButton.setFocusable(false);
		netPlusButton.setFont(new Font("Courier New", Font.BOLD, 16));

		secPlusButton.setText("Security+");
		secPlusButton.setFocusable(false);
		secPlusButton.setFont(new Font("Courier New", Font.BOLD, 16));

		cehButton.setText("CEH");
		cehButton.setFocusable(false);
		cehButton.setFont(new Font("Courier New", Font.BOLD, 16));

		dataCourseButton.setText("Spartan Data Course");
		dataCourseButton.setFocusable(false);
		dataCourseButton.setFont(new Font("Courier New", Font.BOLD, 16));

		ButtonGroup groupButtons = new ButtonGroup(); //Group RadioButtons together
		groupButtons.add(netPlusButton);
		groupButtons.add(secPlusButton);
		groupButtons.add(cehButton);
		groupButtons.add(dataCourseButton);

		panelCheckBox.add(netPlusButton);
		panelCheckBox.add(secPlusButton);
		panelCheckBox.add(cehButton);
		panelCheckBox.add(dataCourseButton);

		button = new JButton(); //Create NEXT button
		button.setBounds(450, 725, 100, 50); //x, y of top corner, width, height of button
		button.addActionListener(this); //-> is a lambda expression
		button.setText("NEXT");
		button.setFocusable(false);
		button.setFont(new Font("Courier New", Font.BOLD, 20));

		errorMessagePanel = new JPanel(); //Present error message if all textfields are not filled out
		errorMessagePanel.setBackground(new Color(175, 175, 175));
		errorMessagePanel.setBounds(50, 610, 900, 50);
		firstErrorMessage = new JLabel();
		firstErrorMessage.setForeground(Color.red); //Set color of text
		firstErrorMessage.setText("ERROR! INPUT IS REQUIRED FOR ALL ELEMENTS!!"); //Set text of label
		firstErrorMessage.setFont(new Font("Courier New", Font.BOLD, 22)); //Change the font type
		firstErrorMessage.setHorizontalAlignment(JLabel.CENTER);
		firstErrorMessage.setVerticalAlignment(JLabel.CENTER);
		errorMessagePanel.add(firstErrorMessage);
		errorMessagePanel.setVisible(false);

		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.getContentPane().setBackground(new Color(50, 50, 50)); //new Color lets you add a new color
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(errorMessagePanel);
		this.add(button);
		this.add(panel);
		this.add(panelCheckboxTitle);
		this.add(panelCheckBox);
		this.pack();
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setVisible(true); //Makes frame visible
	}//end RegistrationPage() method

	public void actionPerformed(ActionEvent e){
		if (e.getSource()==button){
			String edipi = textField.getText();
			String rank = textField1.getText();
			String lastName = textField2.getText();
			String firstName = textField3.getText();
			String unit = textField4.getText();
			Boolean netPlusBoolean = netPlusButton.isSelected();
			Boolean secPlusBoolean = secPlusButton.isSelected();
			Boolean cehBoolean = cehButton.isSelected();
			Boolean dataCourseBoolean = dataCourseButton.isSelected();
			String examType = "";

			if (netPlusBoolean == true){
				examType = "Network_Plus";
				System.out.println(netPlusBoolean);
			}
			if (secPlusBoolean == true){
				examType = "Security_Plus";
				System.out.println(secPlusBoolean);
			}
			if (cehBoolean == true){
				examType = "CEH";
			}
			if (dataCourseBoolean == true){
				examType = "Spartan_Data_Course";
			}
			if (dataCourseBoolean == false && cehBoolean == false && secPlusBoolean == false && netPlusBoolean == false) {
				errorMessagePanel.setVisible(true);
				timer = new Timer(2000, new ActionListener(){
					public void actionPerformed(ActionEvent e){
						errorMessagePanel.setVisible(false);
						timer.stop();
					}
				});
				timer.start();
			}
			else{ //if all fields are not filled out, present an error message for 2 seconds at bottom of the JFrame
				if (edipi.equals("") || rank.equals("")|| lastName.equals("") || firstName.equals("") || unit.equals("")){
					errorMessagePanel.setVisible(true);
					timer = new Timer(2000, new ActionListener(){
						public void actionPerformed(ActionEvent e){
							errorMessagePanel.setVisible(false);
							timer.stop();
						}
					});
					timer.start();
				}
				else{
					this.dispose();
					try{
						write.write(edipi, rank, lastName, firstName, unit, examType);
						int counter = 0;
						Input input = new Input();
						input.addVariables(lastName, firstName, examType, questionCounter, correctAnswerCounter, rank);
					} catch (IOException exception){
						System.out.println("ERROR WITH WRITING!");
					}
				}
			}
		}
	}//actionPerformed method()
}//End RegistrationPage class