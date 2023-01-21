import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.io.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.text.DecimalFormat;

/**
* The MyFrame class renders the quiz for the user. 
* 
* Pre-condition: EDIPI, Rank, Last Name, First Name, Unit, and Test Type
* 
* Post-Condition: User clicks submit and the Submit class is called to send the final score via email
* 
* @author Daniel Chisner
*/

public class MyFrame extends JFrame{
	Input input = new Input();	Submit submit = new Submit();
	String[] array = new String[6];
	JPanel panel, panel1, panel2, panel3, panel4, panel5;
	String lastName, firstName, testType, answer, rank;
	int questionCounter = 1, correctAnswerCounter;
	Write write = new Write();

	public void addToArray(String[] arrayQuestions, String lName, String fName, String examType, String rankOf){
		array = arrayQuestions;
		lastName = lName;
		firstName = fName;
		testType = examType;
		rank = rankOf;

		ImageIcon image = new ImageIcon("MACG28Logo.png"); //Top left corner
		ImageIcon image1 = new ImageIcon("MWCS28Logo.png"); //Top right corner

		panel = new JPanel(); //Separate JPanel into 5 columns and use this panel for the RadioButtons for test questions
		panel.setBackground(Color.gray);
		panel.setBounds(150, 200, 30, 400);
		panel.setLayout(new GridLayout(5,1));
		this.add(panel);//add to JFrame

		panel1 = new JPanel(); //Panel behind the test question
		panel1.setBackground(Color.gray);
		panel1.setBounds(180, 200, 675, 103);
		this.add(panel1);

		panel2 = new JPanel(); //JPanel behind first answer choice for test questions (top)
		panel2.setBackground(Color.gray);
		panel2.setBounds(180, 303, 675, 80);
		this.add(panel2);

		panel3 = new JPanel(); //JPanel behind second answer choice for test questions (2nd from top)
		panel3.setBackground(Color.gray);
		panel3.setBounds(180, 383, 675, 80);
		this.add(panel3);

		panel4 = new JPanel(); //JPanel behind thid answer choice for test questions (3rd from top)
		panel4.setBackground(Color.gray);
		panel4.setBounds(180, 463, 675, 80);
		this.add(panel4);

		panel5 = new JPanel(); //JPanel behind last answer choice for test questions 
		panel5.setBackground(Color.gray);
		panel5.setBounds(180, 543, 675, 57);
		this.add(panel5);

		JRadioButton radiobutton1 = new JRadioButton(); //Network+ Button
		JRadioButton radiobutton2 = new JRadioButton(); //Security+ Button
		JRadioButton radiobutton3 = new JRadioButton(); //CEH Button
		JRadioButton radiobutton4 = new JRadioButton(); //Spartan Data Course


		JTextArea label1 = new JTextArea(5, 60); //Makes the area to the left of the question prompt filled in
		label1.setText("");
		label1.setFont(new Font("Courier New", Font.BOLD, 20)); //Change the font type
		label1.setWrapStyleWord(true);
		label1.setLineWrap(true);
		label1.setBackground(Color.gray);
		label1.setEditable(false);

		JTextArea questionTextArea = new JTextArea(5, 72); //Shows the question prompt in the top box
		questionTextArea.setText(array[0]);
		questionTextArea.setFont(new Font("Courier New", Font.BOLD, 15)); //Change the font type
        questionTextArea.setMargin(new Insets(10,10,10,10));
		questionTextArea.setWrapStyleWord(true);
		questionTextArea.setLineWrap(true);
		questionTextArea.setBackground(Color.gray);
		questionTextArea.setEditable(false);

		JTextArea answer1TextArea = new JTextArea(5, 55); //Show first choice text
		answer1TextArea.setText(array[1]);
		answer1TextArea.setFont(new Font("Courier New", Font.BOLD, 20)); //Change the font type
        answer1TextArea.setMargin(new Insets(0,10,10,10));
		answer1TextArea.setWrapStyleWord(true);
		answer1TextArea.setLineWrap(true);
		answer1TextArea.setBackground(Color.gray);
		answer1TextArea.setEditable(false);

		JTextArea answer2TextArea = new JTextArea(5, 55); //Show second choice text
		answer2TextArea.setText(array[2]);
		answer2TextArea.setFont(new Font("Courier New", Font.BOLD, 20)); //Change the font type
        answer2TextArea.setMargin(new Insets(0,10,10,10));
		answer2TextArea.setWrapStyleWord(true);
		answer2TextArea.setLineWrap(true);
		answer2TextArea.setBackground(Color.gray);
		answer2TextArea.setEditable(false);

		JTextArea answer3TextArea = new JTextArea(5, 55); //Show third choice text
		answer3TextArea.setText(array[3]);
		answer3TextArea.setFont(new Font("Courier New", Font.BOLD, 20)); //Change the font type
        answer3TextArea.setMargin(new Insets(0,10,10,10));
		answer3TextArea.setWrapStyleWord(true);
		answer3TextArea.setLineWrap(true);
		answer3TextArea.setBackground(Color.gray);
		answer3TextArea.setEditable(false);

		JTextArea answer4TextArea = new JTextArea(5, 55); //Show fourth choice text
		answer4TextArea.setText(array[4]);
		answer4TextArea.setFont(new Font("Courier New", Font.BOLD, 20)); //Change the font type
        answer4TextArea.setMargin(new Insets(0,10,10,10));
		answer4TextArea.setWrapStyleWord(true);
		answer4TextArea.setLineWrap(true);
		answer4TextArea.setBackground(Color.gray);
		answer4TextArea.setEditable(false);

		ButtonGroup groupButtons = new ButtonGroup(); //
		groupButtons.add(radiobutton1);
		groupButtons.add(radiobutton2);
		groupButtons.add(radiobutton3);
		groupButtons.add(radiobutton4);

		panel.add(label1);
		panel.add(radiobutton1);
		panel.add(radiobutton2);
		panel.add(radiobutton3);
		panel.add(radiobutton4);

		panel1.add(questionTextArea);
		panel2.add(answer1TextArea);
		panel3.add(answer2TextArea);
		panel4.add(answer3TextArea);
		panel5.add(answer4TextArea);

		JLabel label = new JLabel();
		JLabel macgLogo = new JLabel();
		JLabel mwcsLogo = new JLabel();
		this.add(label);
		label.setText("MWCS-28 Testing Center"); //Set set text of label
		label.setHorizontalTextPosition(JLabel.RIGHT);//Set text left, right, right of image
		label.setVerticalTextPosition(JLabel.CENTER); //Set text TOP, CENTER, BOTTOM
		//label.setForeground(new Color(0, 0, 0)); //Set color of text
		label.setFont(new Font("Courier New", Font.BOLD, 40)); //Change the font type
		label.setVerticalAlignment(JLabel.CENTER); //set location of the label to top
		label.setHorizontalAlignment(JLabel.CENTER); //Set location of label to center
		this.setLayout(null);
		label.setBackground(new Color(210, 210, 210));
		label.setOpaque(true);
		label.setBounds(175, 0, 675, 100);

		this.add(macgLogo); //Add MACG28 logo to top left corner
		macgLogo.setIcon(image);
		macgLogo.setHorizontalAlignment(JLabel.CENTER);
		macgLogo.setVerticalAlignment(JLabel.TOP);
		macgLogo.setBackground(new Color(210, 210, 210));
		macgLogo.setOpaque(true);
		macgLogo.setBounds(0, 0, 200, 100);

		this.add(mwcsLogo); //Add MWCS-28 logo to top right corner
		mwcsLogo.setIcon(image1);
		mwcsLogo.setHorizontalAlignment(JLabel.LEFT);
		mwcsLogo.setVerticalAlignment(JLabel.TOP);
		mwcsLogo.setBackground(new Color(210, 210, 210));
		mwcsLogo.setOpaque(true);
		mwcsLogo.setBounds(840, 0, 1000, 100);
		this.add(label);

		JLabel label2 = new JLabel();
		label2.setText(""); //Set set text of label
		JButton button = new JButton();
		button.setBounds(475, 700, 100, 50); //x, y of top corner, width, height of button
		button.setText("NEXT");
		button.setFocusable(false);
		button.setFont(new Font("Courier New", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			@Override
			//actionPerformed used to determine what RadioButton and if it was right/wrong
	        public void actionPerformed(ActionEvent arg0) {
				if (radiobutton1.isSelected()==true){
					answer = "Answer: A";
				}
				if (radiobutton2.isSelected()==true){
					answer = "Answer: B";
				}
				if (radiobutton3.isSelected()==true){
					answer = "Answer: C";
				}
				if (radiobutton4.isSelected()==true){
					answer = "Answer: D";
				}
				if (answer.equals(array[5])){
					correctAnswerCounter++;
				}
				if (questionCounter == 49){
					button.setText("SUBMIT");
					button.setForeground(Color.red);
				}
				if (questionCounter == 50){ //if question counter equals 50 then calculate score
					float answers = correctAnswerCounter;
					float score = answers / 50 * 100;
  					DecimalFormat df = new DecimalFormat("0.00");
  					df.format(score);
					try{
						write.writeFinal(score, firstName, lastName); //write score to OUTPUT folder
					}catch(IOException except){
			        	System.out.println("ERROR!!! Incorrect file name!!");	
					}
					submit.submit(firstName, rank, lastName, score, testType);
				}
				try{
	      			for (int i = 0; i <= 5; i++) {
				    	array[i] = "";
					}
					int counter = 0;
					questionCounter++;
					//retrieve next question
					input.addVariables(lastName, firstName, testType, questionCounter, correctAnswerCounter, rank);
				}
			    catch (IOException exception) { //Catch incorrect user input file
			        System.out.println("ERROR!!! Incorrect file name!!");
			    }  
			    answer = "";
	        	groupButtons.clearSelection(); //clear the answer choice
	        	questionTextArea.setText(array[0]); //update question prompt
	            answer1TextArea.setText(array[1]); //update answer options based on current question
	            answer2TextArea.setText(array[2]);
	            answer3TextArea.setText(array[3]);
	            answer4TextArea.setText(array[4]);
	        }//End ActionPerformed method
	    });//End addActionListener
		this.setTitle("MWCS-28 Testing Center"); //set title of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets close to actually close out app instead of hide
		this.getContentPane().setBackground(new Color(175, 175, 175)); //new Color lets you add a new color
		this.add(button);
		this.add(label2);
		this.pack();
		this.setSize(1000, 800);//Set size of frame to 1000 by 800 px
		this.setResizable(false); //prevents the frame from moving to ensure Marines fill out the information
		this.setVisible(true); //Makes frame visible
	}//end AddToArray method
}//end MyFrame class