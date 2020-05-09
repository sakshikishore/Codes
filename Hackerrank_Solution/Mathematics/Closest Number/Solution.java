import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the closestNumber function below.
     */
    static long closestNumber(int a, int b, int x) {
        /*
         * Write your code here.
         */
         long result=0;
         if(b>0)
         {
         BigInteger p=BigInteger.valueOf(a).modPow(BigInteger.valueOf(b),BigInteger.valueOf(x));
         long s=(long)Math.pow(a,b);
         int l=p.intValue();
         if(l<=x/2)
         {
             result=s-l;
         }
         else
         {
             result=s+(x-l);
         }
         }
         else
         {
             if(a==1)
             {
                 long s=1;
                 long l=s%x;
                 if(l<=x/2)
         {
             result=s-l;
         }
         else
         {
             result=s+(x-l);
         }
             }
         }
 return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] abx = scanner.nextLine().split(" ");

            int a = Integer.parseInt(abx[0].trim());

            int b = Integer.parseInt(abx[1].trim());

            int x = Integer.parseInt(abx[2].trim());

            long result = closestNumber(a, b, x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
