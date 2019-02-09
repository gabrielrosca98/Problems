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

public class Laundry
{
  public static String clothing;
  public static Map<String, Integer> laundryMap = new TreeMap<String, Integer>();
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
      while((clothing = input.readLine()) != null)
      {
        if(laundryMap.get(clothing) == null)
        {
          laundryMap.put(clothing, 1);
        }
        else
        {
          laundryMap.put(clothing, laundryMap.get(clothing) + 1);
        }
      }

      Iterator<Map.Entry<String, Integer>> listLaundry = laundryMap.entrySet().iterator();
      while(listLaundry.hasNext())
      {
        Map.Entry<String, Integer> cloth = listLaundry.next();
        if(cloth.getKey().indexOf("sock") == -1)
        {
          output.println(cloth.getValue() + "|" + cloth.getKey());
        }
        else
        {
          if(cloth.getValue() == 1)
          {
            output.println(0 + "|" + cloth.getKey());
          }
          else
          {
            output.println((cloth.getValue() / 2) + "|" + cloth.getKey());
            if(cloth.getValue() % 2 == 1)
            {
              output.println(0 + "|" + cloth.getKey());
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
