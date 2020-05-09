import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        String p="";
      int ch[]=new int[26];
      for(int i=0;i<s.length();i++)
      {
          ch[s.charAt(i)-'a']++;
      }
      int count=0,l=0,t=0;
      for(int i=0;i<26;i++)
      {
          if(ch[i]!=0)
          {
              l++;
          }
          if(ch[i]==ch[s.charAt(0)-'a'])
          {
              count++;
          }
          if(s.length()>1)
          {
          if(ch[i]==ch[s.charAt(1)-'a'])
          {
             t++;
          }
          }
      }
      if(count==l ||count==l-1)
      {
          p="YES";
      }
      else if(t==l || t==l-1)
      {
          p="YES";
      }
      else
      {
          p="NO";
      }
      return p;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
