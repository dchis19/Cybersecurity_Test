import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;

/*
* This Input class takes the user input, stores the variables passed to the class, and uses the variables to generate
* the proper test questions for the user.
* 
* @preconditions 1: Input file
*  
* @post condition: integerList returned to main program.
* 
* @author Daniel Chisner
*/

public class Input{
	static String lastName, firstName, testType, rank;
	static int questionCounter = 1, counter, correctAnswerCounter;
	static String[] arrayQuestions = new String[6];
	static MyFrame frame = new MyFrame();
	static String line = "";
	public static void addVariables(String lName, String fName, String type, int questionNum, int correctAnswerNum, 
		String rankOf) throws IOException{
		counter = 0;
		lastName = lName;
		firstName = fName;
		testType = type;
		rank = rankOf;
		correctAnswerCounter = correctAnswerNum;
		questionCounter = questionNum;
        String filePath = System.getProperty("user.dir");
		String file = filePath + "/" + testType + "/Question" + questionCounter + ".txt";
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        //While line in input string does not equal empty, continue running
	        while ((line = br.readLine()) != null) {
	            try{
	            	conversion(line);   //Start conversion function
	            }
	            catch (NoSuchElementException exceptionError){   //Catch empty list exception
	            	String errorEmpty = "ERROR! Queue is empty!";
	            	System.out.println(errorEmpty);
	            }
	        }
	    }
	    catch (FileNotFoundException exception) { //Catch incorrect user input file
	        System.out.println("ERROR!!! Incorrect file name!!");
	    }       
		frame.addToArray(arrayQuestions, lastName, firstName, testType, rank);
	}//End addVariables() method

	//The conversion method is used to retrieve the next test question and converts it from an array into String

	public static void conversion(String line){
		Conversion conversion = new Conversion();
    	String question = conversion.conversion(line);
    	arrayQuestions[counter] = question;
    	counter++;
	}//End conversion() method
}//End Input class