import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

 private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for(int s=0;s<t;s++)
        {
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            ArrayList<Integer> l=new ArrayList<Integer>();
            int j=0;
            for(int i=0;i<n;i=i+2)
            {
                l.add(n-1-j);
                
                if(i+1<n)
                {
                l.add(j);
                }
                j++;
            }
    
        
            System.out.println(l.indexOf(k));
        }

        scanner.close();
    }
}
