import java.io.*;
import java.util.*;

public class ProblemJPMorgan
{
  //Given n sentences and q queries, for each query print the number of sentences
  public static List<String> sentences = new ArrayList<String>();
  public static List<String> queries = new ArrayList<String>();
  public static LinkedHashMap<String, Integer>probl(List<String> theSent, List<String> theQ)
  {
    LinkedHashMap<String, Integer> frequency = new LinkedHashMap<String, Integer>();
    for(String valueQ: theQ)
    {
      String[] wordsQ = valueQ.split(" ");
      for(String valueS: theSent)
      {
        boolean containAll = true;
        String[] words = valueS.split(" ");
        HashSet<String> wordS = new HashSet<String>(Arrays.asList(words));
        for(String wordQQ : wordsQ)
        {
          if(!wordS.contains(wordQQ))
          {
            containAll = false;
            break;
          }
        }
        if(containAll)
        {
          frequency.put(valueQ, frequency.getOrDefault(valueQ, 0) + 1);
        }
      }
    }
    return frequency;
  }
  public static void main(String[] args){
    try{
      Scanner input = new Scanner(new FileReader(args[0]));
      PrintWriter output = new PrintWriter(new OutputStreamWriter(System.out));
      int numberSenteces = input.nextInt();
      int numberQueries = input.nextInt();
      input.nextLine();
      for(int index = 0; index < numberSenteces; index++)
      {
        String currentLine = input.nextLine();
        sentences.add(currentLine);
      }
      for(int index = 0; index < numberQueries; index++)
      {
        String currentLine = input.nextLine();
        queries.add(currentLine);
      }
      LinkedHashMap<String,Integer> answer = probl(sentences, queries);
      for(Map.Entry<String, Integer> entry : answer.entrySet())
      {
        System.out.println(entry.getKey() + " " + entry.getValue());
      }
    }
    catch(Exception exception){
      System.err.println(exception);
    }

  }
}
