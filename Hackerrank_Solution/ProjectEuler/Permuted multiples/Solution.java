import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        for(int i=1;i<=n;i++)
        {
            int arr[]=new int[10];
            String str=Integer.toString(i);
            int count=0;
            for(int l=0;l<str.length();l++)
            {
               arr[str.charAt(l)-'0']++;
            }
            for(int j=2;j<=k;j++)
            {
              int p=j*i;
              String s=Integer.toString(p);
              int a[]=new int[10];
              for(int l=0;l<s.length();l++)
              {
                a[s.charAt(l)-'0']++;
              }
              for(int t=0;t<10;t++)
              {
                  if(a[t]!=arr[t])
                  {
                      count++;
                      break;
                  }
              }
                  
            }
            if(count==0)
            {
                for(int j=1;j<=k;j++)
                {
                System.out.print(i*j+" ");
                }
                System.out.println();
            }
        }
}
}
