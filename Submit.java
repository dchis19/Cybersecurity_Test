import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.MessagingException;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;

/**
* The Submit class is utilized to send an email to an inbox. The email on this code is utilized for a test environment ONLY.
* 
* Pre-condition: EDIPI, Rank, Last Name, First Name, Unit, and Test Type
* 
* Post-Condition: Output file is written to the OUTPUT Folder
* 
* @author Daniel Chisner
*/

public class Submit{
	public static void submit(String firstName, String rank, String lastName, float score, String test){
        final String username = "REDACTED-FROM@gmail.com"; //UPDATE EMAIL WITH THE OFFICIAL EMAIL
        final String password = "REDACTED-FROM"; //UPDATE PASSWORD WITH THE APPROPRIATE INFORMATION

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.3"); //use TLS v1.3 to secure the email in transport
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }); //Start a new email session

        try {
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("REDACTED-FROM@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("REDACTED-TO@aol.com")
            );
            if (score<=80){ //If the score is below 80% then the Email autogenerates to inform the TO recipient
            	message.setSubject(lastName + " " + rank + " " + firstName + " FAILED " + test);
            	if (test == "Security_Plus" || test == "Network_Plus" || test == "CEH"){
            		messageBodyPart.setText(lastName + " " + rank + " " + firstName + " FAILED " + test + " with a score of: " + score
                    + "\n\n DO NOT REGISTER MARINE FOR " + test.toUpperCase() + "IF REQUESTED!!");
                }
                else{
                	messageBodyPart.setText(lastName + " " + rank + " " + firstName + " failed " + test + " with a score of: " + score);
                }
            }
            else{
            	message.setSubject(lastName + " " + rank + " " + firstName + " PASSED " + test); //If passed then the email reflects that
				messageBodyPart.setText(lastName + " " + rank + " " + firstName + " passed " + test + " with a score of: " + score
                    + "\n\n REGISTER MARINE FOR " + test.toUpperCase() + "IF REQUESTED!");
            }


	        MimeMultipart multipart = new MimeMultipart();
	        
       		String filePath = System.getProperty("user.dir");
	        String fileName = (filePath+ "/OUTPUT/" +firstName + "_" + lastName + ".txt");
        	DataSource source = new FileDataSource(fileName);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(lastName + " " + rank + " " + firstName + " " + test + ".txt");
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

            Transport.send(message);

            System.out.println("EMAIL SENT!!"); //Let the end user know in the terminal/CLI that the email was sent

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}