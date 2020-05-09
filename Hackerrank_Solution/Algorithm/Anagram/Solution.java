import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        int result=0;
        if(s.length()%2!=0)
        {
            result=-1;
        }
        else
        {
            int ch[]=new int[26];
            for(int i=0;i<s.length()/2;i++)
            {
                ch[s.charAt(i)-'a']++;
            }
            for(int i=s.length()/2;i<s.length();i++)
            {
                ch[s.charAt(i)-'a']--;
            }
            for(int i=0;i<26;i++)
            {
                if(ch[i]>0)
                {
                    result+=ch[i];
                }
            }
        }
          return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
