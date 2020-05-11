import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
      char c[]=w.toCharArray();
      String str="no answer";
      for(int i=w.length()-1;i>=1;i--)
      {
         if(c[i]>c[i-1])
         {
             
             int p=i;
             while(c[p]>c[i-1])
             {
                 p++;
                 if(p==w.length())
                 {
                     break;
                 }
             }
             p--;
             
             String k=w.substring(p+1);
             StringBuffer sb=new StringBuffer(k);
             String h=new String(sb.reverse());
             String g=w.substring(i,p);
             StringBuffer st=new StringBuffer(g);
             String l=new String(st.reverse());
             str=w.substring(0,i-1)+w.substring(p,p+1)+h+w.substring(i-1,i)+l;

             break;
            

         }
      }
      
           return str;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
