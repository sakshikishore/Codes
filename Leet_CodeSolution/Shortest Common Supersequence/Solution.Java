public class Node
{
    int row,col,count;
    String str;
    public Node(int i, int j, int c, String s)
    {
       row=i;
       col=j;
       count=c;
       str=s;
    }
}
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.equals(str2))
        {
            return str1;
        }
       int arr[][]=new int[str1.length()+1][str2.length()+1];
       for(int i=1;i<=str1.length();i++)
       {
        for(int j=1;j<=str2.length();j++)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                arr[i][j]=arr[i-1][j-1]+1;
            }
            else
            {
                arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
            }
        }
       }
       int cnt=arr[arr.length-1][arr[0].length-1];
       if(cnt==0)
       {
        return str1+str2;
       }
       int visited[][]=new int[arr.length][arr[0].length];
       String res="";
       Queue<Node> q=new LinkedList<Node>();
       q.add(new Node(arr.length-1,arr[0].length-1,arr[arr.length-1][arr[0].length-1],""));
       while(q.size()>0)
       {
          Node node=q.poll();
          int x=node.row;
          int y=node.col;
           if(x-1>=0 && y-1>=0)
           {
          if(str1.charAt(x-1)==str2.charAt(y-1))
          {
              if(node.count-1==0)
                {
                    res=str1.charAt(x-1)+node.str;
                    break;
                }
                if(visited[x-1][y-1]==0)
                {
                    visited[x-1][y-1]=1;
             q.add(new Node(x-1,y-1,node.count-1,str1.charAt(x-1)+node.str));
                }
          }
          else
          {
             if(arr[x-1][y]>arr[x][y-1])
             {
                if(visited[x-1][y]==0)
                {
                    visited[x-1][y]=1;
                q.add(new Node(x-1,y,node.count,node.str));
                }
             }
             else if(arr[x-1][y]<arr[x][y-1])
             {
                if(visited[x][y-1]==0)
                {
                    visited[x][y-1]=1;
                  q.add(new Node(x,y-1,node.count,node.str));
                }
             }
             else
             {
               if(visited[x-1][y]==0)
                {
                    visited[x-1][y]=1;
                q.add(new Node(x-1,y,node.count,node.str));
                }
if(visited[x][y-1]==0)
                {
                    visited[x][y-1]=1;
                  q.add(new Node(x,y-1,node.count,node.str));
                }
             }
          }
           }
       }
       if(res.equals(str2))
       {
        return str1;
       }
       else if(res.equals(str1))
       {
        return str2;
       }
   int j=0;
   ArrayList<Integer> l=new ArrayList<Integer>();
    for(int i=0;i<str1.length();i++)
    {
        if(str1.charAt(i)==res.charAt(j))
        {
            l.add(i);
            j++;
            if(j==res.length())
            {
                break;
            }
        }
    }
    j=0;
 ArrayList<Integer> m=new ArrayList<Integer>();
    for(int i=0;i<str2.length();i++)
    {
        if(str2.charAt(i)==res.charAt(j))
        {
            m.add(i);
            j++;
            if(j==res.length())
            {
                break;
            }
        }
    }
    String result="";
    result=str1.substring(0,l.get(0))+str2.substring(0,m.get(0)+1);
    for(int i=1;i<m.size();i++)
    {
       int start=l.get(i-1)+1;
       int end=l.get(i);
       result+=str1.substring(start,end)+str2.substring(m.get(i-1)+1,m.get(i)+1);
    }

    result+=str1.substring(l.get(l.size()-1)+1)+str2.substring(m.get(m.size()-1)+1);

    return result;

    }
}
