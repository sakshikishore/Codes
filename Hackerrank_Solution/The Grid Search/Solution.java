import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P,int r,int z,int u,int v) {
        
        String str="";
        
        ArrayList<Integer> line=new ArrayList<Integer>();
        int result=0;
        for(int i=0;i<G.length;i++)
        {
            if(G[i].contains(P[0]))
            {
                line.add(i);
            }
        }
        for(int x=0;x<line.size();x++)
        {
        ArrayList<Integer> s=new ArrayList<Integer>();
        ArrayList<Integer> t=new ArrayList<Integer>();
        for(int i=0;i<=v-u;i++)
        {
            if(G[line.get(x)].substring(i,i+u).equals(P[0]))
            {
                s.add(i);
                t.add(i+u);
                
            }
        }
        int flag=0;
        for(int k=0;k<s.size();k++)
        {
            int count=0;
        for(int i=1;i<P.length;i++)
        {
            if(!G[line.get(x)+i].substring(s.get(k),t.get(k)).equals(P[i]))
            {
              
               break;
            }
            else
            {
                count++;
            } 
        }
        if(count==P.length-1)
        {
            flag=1;
            break;
        }
        }
        if(flag==1)
        {
            str="YES";
            result++;
            break;
        }
     
        }
        if(result==0)
        {
            str="NO";
        }

     return str;
         }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];
            int u=0,v=0;

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                v=GItem.length();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                u=PItem.length();
                P[i] = PItem;
            }

            String result = gridSearch(G, P,R,r,u,v);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
