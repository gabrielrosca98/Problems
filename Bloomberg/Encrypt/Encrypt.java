//Problem        : Base Arithmetic
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;

public class Encrypt
{
  public static String word;
  public static Set<Integer> listNumber = new LinkedHashSet<Integer>();
  public static Set<Integer> finalList = new LinkedHashSet<Integer>();
  public static void main(String[] args)
  {
    //Set the input and output to null
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //Set the input and output
      input = new BufferedReader(new FileReader(args[0]));
      output = new PrintWriter(new OutputStreamWriter(System.out));
      int number = Integer.parseInt(input.readLine());
      int sum = 0;
      boolean multipleSol = false;
      for(int index = 0; index < number; index++)
      {
          int readNumber = Integer.parseInt(input.readLine());
          if(listNumber.add(readNumber) == false)
          {
            multipleSol = true;
          }
          sum += readNumber;
      }
      sum /= (number - 1);
      //output.println(sum);
      Iterator<Integer> list = listNumber.iterator();
      while(list.hasNext())
      {
        Integer numberList = list.next();
        if(sum - numberList < 0 || sum - numberList > 255)
        {
          output.println("NO SOLUTION");
          break;
        }
        else
        {
          if(multipleSol == true)
          {
            output.println("MULTIPLE SOLUTION");
            break;
          }
          finalList.add(sum - numberList);
        }
      }

      Iterator<Integer> listIt = finalList.iterator();
      if(!multipleSol)
      {
        while(listIt.hasNext())
        {
          output.println(listIt.next());
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
