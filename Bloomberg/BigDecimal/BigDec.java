import java.math.BigDecimal;
import java.util.*;
import java.io.*;

class BigDec{
    public static void main(String []args){
        //Input
        try{
        Scanner sc= new Scanner(new FileReader(args[0]));
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        BigDecimal[] numbers = new BigDecimal[n];
        for(int index = 0; index < n; index++)
        {
          numbers[index] = new BigDecimal(s[index]);
        }

        boolean switched = false;
        do{
            switched = false;
            for(int index = 0; index < n - 1; index++)
            {
              if(numbers[index].compareTo(numbers[index + 1]) == -1)
              {
                BigDecimal swap = numbers[index];
                numbers[index] = numbers[index + 1];
                numbers[index + 1] = swap;
                s[index] = s[index] + s[index + 1];
                s[index + 1] = s[index].substring(0, s[index].length() - s[index + 1].length());
                s[index] = s[index].substring(s[index + 1].length());
                switched = true;
              }
            }
        }while(switched == true);
        //Output
        for(int i=0;i<n;i++)
        {
           System.out.println(s[i]);
        }
        }
        catch(Exception exception)
        {
          System.out.println(exception);
        }
    }
}
