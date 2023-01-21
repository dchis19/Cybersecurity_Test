import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;


public class SplashPage extends JFrame{

/**
* The SplashPage class shows the end user the U.S. government warning for accessing a system. 
* 
* Pre-condition: Open file
* 
* Post-Condition: A frame is rendered showing that hte user is accessing a government system
* 
* @author Daniel Chisner
*/

	public void splashPage(){

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

		this.add(macgLogo);
		macgLogo.setIcon(image);
		macgLogo.setHorizontalAlignment(JLabel.CENTER);
		macgLogo.setVerticalAlignment(JLabel.TOP);
		macgLogo.setBackground(new Color(100, 100, 100));
		macgLogo.setOpaque(true);
		macgLogo.setBounds(0, 0, 200, 100);

		this.add(mwcsLogo);
		mwcsLogo.setIcon(image1);
		mwcsLogo.setHorizontalAlignment(JLabel.LEFT);
		mwcsLogo.setVerticalAlignment(JLabel.TOP);
		mwcsLogo.setBackground(new Color(100, 100, 100));
		mwcsLogo.setOpaque(true);
		mwcsLogo.setBounds(840, 0, 1000, 100);
		this.add(label);

		JPanel panel = new JPanel(); //Dark gray to go behind U.S. government prompt
		panel.setBackground(new Color(175, 175, 175));
		panel.setBounds(100, 150, 750, 575);
		this.add(panel);

		JTextArea textArea = new JTextArea(21, 60); //U.S. government prompt
		textArea.setFont(new Font("Courier New", Font.BOLD, 18)); //Change the font type
		textArea.setText(" You are accessing a U.S Government(USG) Information System" +
						"   (IS) that is provided for routinely USG-authorized use" +
						"\n only. By using this IS (which includes any device attached to this IS), you" +
						" consent to the following conditions: The USG intercepts and monitors" +
						" communications on this IS for \n    purposes including, but not limited to," +
						" penetration \ntesting, COMSEC monitoring, network operations and defense," +
						"   personnel misconduct (PM), law enforcement (LE), and \n         counterintelligence (CI)" +
						" investigations." +
						"\n\nAt any time, the USG may inspect and seize data stored on \nthis IS." + 
						" Communications using, or data stored on, this IS \n    are not private, are" +
						" subject to routine monitoring, \ninterception, and search, and may" +
						" bedisclosed or used for \n   any USG-authorized purpose. This IS includes" + 
						" security \nmeasures (e.g., authorization and access controls) to \n     protect USG" +
						" interests -- not for your personal \n                   benefit or privacy." +
						"\n\n     Notwithstanding the above, using this IS does not \nconstitute consent to" +
						" PM, LE or CI investigative searching or monitoring of the content of" +
						" privileged communications,   or work product, related to personal" +
						" representation or \n  services by attorneys, psychotherapists, or clergy, and" +
						" \ntheir assistants. Such communications and work product are                  private and" + 
						" confidential."); //Set set text of label

		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		panel.add(textArea);

		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.getContentPane().setBackground(new Color(50, 50, 50)); //new Color lets you add a new color
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setVisible(true); //Makes frame visible
	}//End SplashPage method
}//End SplashPage class