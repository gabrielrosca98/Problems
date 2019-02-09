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
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;

public class Mug
{
  public static Map<String, Integer> colours = new HashMap<String, Integer>();
  public static String currentColour;
  public static String numberC;
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
      numberC = input.readLine();
      int number = Integer.parseInt(numberC);
      colours.put("White", 1);
      colours.put("Black", 1);
      colours.put("Blue", 1);
      colours.put("Red", 1);
      colours.put("Yellow", 1);

      for(int index = 1; index <= number; index++)
      {
        currentColour = input.readLine();
        colours.put(currentColour, 0);
      }
      Iterator<Map.Entry<String, Integer>> list = colours.entrySet().iterator();
      while(list.hasNext())
      {
        Map.Entry<String, Integer> currentC = list.next();
        if(currentC.getValue() != 0)
        {
          output.println(currentC.getKey());
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
