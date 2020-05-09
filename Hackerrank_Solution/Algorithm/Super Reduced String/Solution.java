import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        int i=1;
        while(i<s.length())
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                s=s.substring(0,i-1)+s.substring(i+1);
                i=1;
            }
            else
            {
                i++;
            }
        }
        if(s.length()==0)
        {
            s="Empty String";
        }
        

        return s;
        


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
