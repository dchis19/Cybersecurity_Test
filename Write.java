import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

/**
* The Write class writes the EDIPI, rank, last name, first name, unit, and test type to the output file. The output file
* is titled Last Name, Rank, First Name, followed by test type. Once the user finishes the exam, a string is written
* as to whether he/she passed and the percentage. Passing is counted at 80% or higher for any exam. 
* 
* Pre-condition: EDIPI, Rank, Last Name, First Name, Unit, and Test Type
* 
* Post-Condition: Output file is written to the OUTPUT Folder
* 
* @author Daniel Chisner
*/

public class Write{

/**
* The write() method takes the EDIPI, rank, last name, first name, unit, and test type and write it to the output file. 
*/

    static void write(String edipi, String rank, String lastName, String firstName, String unit, String testType) throws IOException{
        LocalDate date = LocalDate.now();
        String filePath = System.getProperty("user.dir"); //Pull the directory path for the application
        FileWriter fw = new FileWriter(filePath+ "/OUTPUT/" +firstName + "_" + lastName + ".txt", true);
        fw.write("DATE: " + date + "\n\nEDIPI: " + edipi + "   " + "RANK: " + rank + "   " + "LAST NAME: " + lastName + "   " + 
        "FIRST NAME: " + firstName + "   " + "UNIT: " + unit + "\n\n" + "TEST TYPE: " + testType + "\n\n");
        fw.close();
    }//end write() method

/**
* The writeFinal() method writes the final score from the exam to the output file created in the write() method. If the score
* is below 80 percent, then the Marine failed the exam and an output string stating Failure! Score: [insert score]. Otherwise, 
* "Pass! Score: [insert score]" is written to the output file. 
*/

    static void writeFinal(float score, String firstName, String lastName) throws IOException{
        String filePath = System.getProperty("user.dir"); //Pull the directory path for the application
        FileWriter fw = new FileWriter(filePath+ "/OUTPUT/" +firstName + "_" + lastName + ".txt", true);
        if (score < 80){ //if score is below 80 write the Marine failed with score
            fw.write("\n\nFAILURE!!!" + "\tSCORE: " + score);
        }
        else{ //Else write passed with score
            fw.write("\n\nPASS!!!" + "\tSCORE: " + score);
        }
        fw.close();
    }//end writeFinal() method
}//end Write class