public class MergeSort
{
  public static int[] sort(int[] arrayLeft, int[] arrayRight, int lenght)
  {
    
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
