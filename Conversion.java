import java.io.*;
import java.lang.*;
import java.util.*;

/*
* This Conversion class will take the input file string and return it.
* 
* @preconditions 1: Input file
*  
* @post condition: stringInput returned to main program.
* 
* @author Daniel Chisner
*/


public class Conversion{
   static String conversion(String input)
   {
      String stringInput = "";
      for(int m = 0; m <= input.length() - 1; m++)
      {
         stringInput = stringInput + input.charAt(m); //
      }
      return stringInput; //return stringInput
   }//End conversion() method
}//End Conversion class