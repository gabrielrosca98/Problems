//Problem        : Passport Control
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.8
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       int agents = Integer.parseInt(stdin);
       int[] agent = new int[agents];
       int groupsNumber = Integer.parseInt(stdin);
       int[] groups = new int[groupsNumber];
       int[] taken = new int[agents];
       int[] time = new int[agents];
       for(int index = 0; index < groupsNumber; index++)
       {
         groups[index] = Integer.parseInt(stdin);
         sum += groups;
       }
       int indexGroup = 0;
       while(sum > 0)
       {
         for(int index = 0; index < agents; index++)
         {
           if(time[index] == 0)
           {
             sum-=groups[indexGroup];
             indexGroup++;
             time[index] = groups[indexGroup];
             agents[index]++;
           }
           else
           {
             time[index]--;
           }
         }
       }
       System.out.println()
       stdin.close();
    }

}
