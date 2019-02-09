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

public class Compliance
{
  public static String word;
  public static Map<Character, Integer> characters = new HashMap<Character, Integer>();
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
      word = input.readLine();
      for(int index = 0; index < word.length(); index++)
      {
        if(characters.get(word.charAt(index)) == null)
        {
          characters.put(word.charAt(index), 1);
        }
        else
        {
          characters.put(word.charAt(index), characters.get(word.charAt(index)) + 1);
        }
      }

      Iterator<Map.Entry<Character, Integer>> listChar = characters.entrySet().iterator();
      int oddNumber = 0;
      while(listChar.hasNext() && oddNumber <= 1)
      {
        Map.Entry<Character, Integer> charac = listChar.next();
        if(charac.getValue() % 2 == 1)
        {
          oddNumber++;
        }
      }
      if(oddNumber <= 1)
      {
        output.println("yes");
      }
      else
      {
        output.println("no");
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
