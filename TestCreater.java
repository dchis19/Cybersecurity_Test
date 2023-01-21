import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Collections;
import java.nio.file.Files;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import javax.swing.Timer;

/**
* The TestCreater class inititiates the program by calling the gui() method. In the gui() the RegistrationPage
* file is called followed by the SplashPage file. This allows for the SplashPage frame to appear over the 
* RegistrationPage frame. At the end of the program, a 6 second timer starts and once expired, the SplashPage
* frame is disposed. 
* 
* Files: SplashPage, RegistrationPage
* 
* @author Daniel Chisner
*/


public class TestCreater{
	static Input input = new Input();
	static Timer timer;
	static String testType, lastName, firstName;

	public static void gui() throws IOException{
		SplashPage splashPage = new SplashPage();
		timer = new Timer(6000, new ActionListener(){ //6 second timer
			public void actionPerformed(ActionEvent e){
				splashPage.dispose(); //Once timer is over, close splashPage
				timer.stop();
			}
		});
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.registrationPage();
		splashPage.splashPage(); 
		timer.start(); //Start 6 second timer
	}//End gui()

	public static void main(String[] args) throws IOException{
		gui();
	} //End main()
}//End TestCreater class