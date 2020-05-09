import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
     long result=n;
     for(int i=0;i<n;i++)
     {
         int count=0;
         int l=0;
         int mid_index=-1;
         for(int j=i+1;j<n;j++)
         {
             if(s.charAt(i)!=s.charAt(j))
             {
                 if(count==0)
                 {
                     count++;
                     mid_index=j;
                 }
                 else
                 {
                     l++;
                     break;
                 }
             }
             else
             {
                 if(count==0)
                 {
                     result++;
                 }
                 else
                 {
                     if(i%2==0)
                     {
                         if((mid_index==((i+j)/2)) && j%2==0)
                         {
                             result++;
                         }
                     }
                     else
                     {
                         if(j%2!=0 && mid_index==((i+j)/2))
                         {
                             result++;
                         }

                     }
                 }
             }
             if(l==1)
             {
                 break;
             }
         }
     }
            return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
