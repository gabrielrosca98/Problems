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
import java.util.HashSet;
import java.util.Collections;
import java.util.Map;
import java.util.Iterator;
import java.io.FileReader;

public class DataSet
{
  public static String word;
  public static Map<Integer, Integer> dataSet = new TreeMap<Integer, Integer>();
  public static Map<Integer, Integer> finalSet = new TreeMap<Integer, Integer>();
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
      int numberData = Integer.parseInt(input.readLine());
      for(int index = 0; index < numberData; index++)
      {
        word = input.readLine();
        int byteSum = 0;
        for(int index2 = 0; index2 < word.length(); index2++)
        {
            byteSum += word.charAt(index2);
        }
        dataSet.put(byteSum, index);
      }
      for(int index = 0; index < numberData; index++)
      {
        word = input.readLine();
        int byteSum = 0;
        for(int index2 = 0; index2 < word.length(); index2++)
        {
            byteSum += word.charAt(index2);
        }
        if(dataSet.get(byteSum) != null)
        {
            finalSet.put(dataSet.get(byteSum), index);
            dataSet.remove(byteSum);
        }
        else
        {
          dataSet.put(byteSum, index + 100);
        }
      }
      Iterator<Map.Entry<Integer, Integer>> dataList = dataSet.entrySet().iterator();
      while(dataList.hasNext())
      {
          Map.Entry<Integer, Integer> firstData = dataList.next();
          Map.Entry<Integer, Integer> secondData = dataList.next();
          if(firstData.getValue() < 100)
          {
            finalSet.put(firstData.getValue(), -100 + secondData.getValue());
          }
          else
          {
            finalSet.put(secondData.getValue(), -100 + firstData.getValue());
          }
      }
      Iterator<Map.Entry<Integer, Integer>> fin = finalSet.entrySet().iterator();
      while(fin.hasNext())
      {
          Map.Entry<Integer, Integer> current = fin.next();
          output.println(current.getKey() + " " + current.getValue());
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
