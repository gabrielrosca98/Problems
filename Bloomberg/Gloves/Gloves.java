//Problem        : Base Arithmetic
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
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

public class Gloves
{
  public static String word;
  public static StringBuilder reverseWord;
  public static Map<String, String> listGloves = new HashMap<String, String>();
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
      int numberClothes = Integer.parseInt(input.readLine());
      //output.println(numberClothes);
      int numberGloves = 0;
      for(int index = 0; index < numberClothes; index++)
      {
        word = input.readLine();
        reverseWord = new StringBuilder();
        reverseWord.append(word);
        reverseWord = reverseWord.reverse();
        if(!word.equals(reverseWord.toString()))
        {
            if(listGloves.get(reverseWord.toString()) == "")
            {
                listGloves.put(reverseWord.toString(), word);
            }
            else
            {
                if(reverseWord.toString().equals(listGloves.get(word)))
                {
                  numberGloves++;
                }
                listGloves.put(word, "");
            }
        }
      }
      int ok = 1;
      Iterator<Map.Entry<String, String>> gloves = listGloves.entrySet().iterator();
      while(gloves.hasNext())
      {
          Map.Entry<String, String> current = gloves.next();
          if(current.getValue().equals(""))
          {
            ok = -1;
          }
          else
          {
            numberGloves++;
          }
      }
      if(ok != -1)
      {
        output.println(numberGloves);
      }
      else
      {
        output.println(-1);
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
