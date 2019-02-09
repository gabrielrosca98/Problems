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
public class Palindrom
{
  public static String palindrom;
  public static String reverseString;
  public static String reverse(String a) {
    int j = a.length();
    char[] newWord = new char[j];
    for (int i = 0; i < a.length(); i++) {
        newWord[--j] = a.charAt(i);
    }
    return new String(newWord);
}
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
      palindrom = input.readLine();
      int number = 1;
      for(int index = 1; index < palindrom.length(); index++)
      {
        if(palindrom.charAt(index) != palindrom.charAt(index - 1))
        {
          break;
        }
        number++;
      }
      reverseString = reverse(palindrom);
      if(!reverseString.equals(palindrom))
      {
        output.println(2 * palindrom.length() - number);
      }
      else{
        output.println(0);
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
