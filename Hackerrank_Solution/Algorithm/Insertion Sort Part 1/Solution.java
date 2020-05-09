import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
     for(int j=1;j<n;j++)
     {
         int key=arr[j];
        int i=j-1;
         while(i>=0 && arr[i]>key)
         {
           arr[i+1]=arr[i];
             for(int k=0;k<n;k++)
   {
       System.out.print(arr[k]+" ");
   }
         System.out.println();
             i=i-1;
         }
         arr[i+1]=key;
         if((i+1)!=j)
         {
              for(int k=0;k<n;k++)
   {
       System.out.print(arr[k]+" ");
   }
         }
        
         
    
    }
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
