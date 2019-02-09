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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;

public class Rugby
{
  public static int number;
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
      number = Integer.parseInt(input.readLine());
      for(int index1 = 0; index1 <= number / 7; index1++)
      {
        for(int index2 = 0; index2 <= number / 3; index2++)
        {

          for(int index3 = 0; index3 <= number / 2; index3++)
          {

            if(index1 * 7 + index2 * 3 + index3 * 2 == number)
            {
              output.println(index1 + " " + index2 + " " + index3);
            }
          }
        }
      }
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
