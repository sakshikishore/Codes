import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

static void nextMove(int n, int r, int c, String [] grid){
    String result="";
    for(int i=0;i<n;i++)
    {
        if(grid[i].contains("p"))
        {
            int l=grid[i].indexOf("p");
            if(r==i)
            {
                if(l>c)
                {
                    result="RIGHT";
                }
                if(l<c)
                {
                    result="LEFT";
                }
            }
            else if(r>i)
            {
                result="UP";
            }
            else
            {
                result="DOWN";
            }
            break;
        }
    }
    System.out.println(result);
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);

    }
}
