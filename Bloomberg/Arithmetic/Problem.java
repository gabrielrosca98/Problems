//Problem        : Base Arithmetic
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Problem
{
  public static String firstElement;
  public static String secondElement;
  public static void main(String[] args)
  {
    //Set the input and output to null
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //Set the input and output
      input = new BufferedReader(new InputStreamReader(System.in));
      output = new PrintWriter(new OutputStreamWriter(System.out));

      firstElement = input.readLine();
      secondElement = input.readLine();
      int maxElement1 = (int)firstElement.charAt(0);
      for(int index = 1; index < firstElement.length(); index++)
      {
        int newMax = (int)firstElement.charAt(index);
        maxElement1 = newMax > maxElement1 ? newMax : maxElement1;
      }

      int baseOne = maxElement1 <= 57 ? maxElement1 - 47 : maxElement1- 54;
      int newNumber1 = 0;
      int power = 1;
      output.println(baseOne + " ");
      for(int index = firstElement.length() - 1; index >= 0; index--)
      {
        int digit = (int)firstElement.charAt(index) <= 57 ? (int)firstElement.charAt(index) - 48 : (int)firstElement.charAt(index)- 55;
        newNumber1 += digit * power;
        power *= baseOne;
      }

      int maxElement2 = (int)secondElement.charAt(0);
      for(int index = 1; index < secondElement.length(); index++)
      {
        int newMax = (int)secondElement.charAt(index);
        maxElement2 = newMax > maxElement2 ? newMax : maxElement2;
      }

      int baseTwo = maxElement2 <= 57 ? maxElement2 - 47 : maxElement2 - 54;
      int newNumber2 = 0;
      power = 1;
      for(int index = secondElement.length() - 1; index >= 0; index--)
      {
        int digit = (int)secondElement.charAt(index) <= 57 ? (int)secondElement.charAt(index) - 48 : (int)secondElement.charAt(index)- 55;
        newNumber2 += digit * power;
        power *= baseTwo;
      }
      output.println(newNumber2 + newNumber1);
    }
    catch (Exception exception)
    {
      System.err.println(exception);
    }
    finally
    {
      //Try to close the input
      try { if(input != null) input.close();}
      catch(IOException exception)
        {System.err.println("Could not close input" + exception);}
      if(output != null)
      {
        //Close the output
        output.close();

        //Check if there was any error during closing the output
        if(output.checkError())
        {
          System.err.println("Something went wrong");
        }
      }//if
    }//finally
  }//main
}//class
