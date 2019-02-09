import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch
{
    public static int[] array;

    public static int searchBinary(int start, int end, int element)
    {
      //Calculate the middle
      int middle = (start + end) / 2;

      //If the middle is equal to the searched element return the position
      if(element == array[middle])
      {
        return middle;
      }

      //If we didn't find the element return -1
      if(start > end)
      {
        return -1;
      }
      //Search on the left side of the array
      else if(element < array[middle])
      {
        return searchBinary(start, middle - 1, element);
      }
      //Search on the right side of the array
      else
      {
        return searchBinary(middle + 1, end, element);
      }
    }

    public static void main(String[] args)
    {
      Scanner input = null;
      PrintWriter output = null;
      try{

        //Initialise the input and output
        input = new Scanner(new FileReader(args[0]));
        output = new PrintWriter(new FileWriter(args[1]));

        //Array length
        int arrayLength = 0;
        array = new int[1000];

        //Get the searched element
        int searchedElement = input.nextInt();
        while(input.hasNextInt())
        {
          array[arrayLength++] = input.nextInt();
        }

        //Sort the array
        Arrays.sort(array, 0 , arrayLength);

        //Print the position of the searched element
        int position = searchBinary(0, arrayLength, searchedElement);
        output.println("The element " + searchedElement + " was found"
                        + " at position " + position);
      }
      catch (Exception exception)
      {
        System.err.println(exception);
      }
      finally
      {
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
    }
}
