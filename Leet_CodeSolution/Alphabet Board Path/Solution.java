public class Node
{
    int x;
    int y;
    String str;
    public Node(int x,int y,String s)
    {
        this.x=x;
        this.y=y;
        this.str=s;
    }
}
class Solution {
    public String alphabetBoardPath(String target) {
        char arr[][]=new char[6][5];
        int k=0;
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<5;j++)
            {
                  arr[i][j]=(char)(97+k);
                  k++;
            }
        }
        Node n=new Node(0,0,"");
        for(int i=0;i<target.length();i++)
        {
            int visited[][]=new int[6][5];
            Queue<Node> q=new LinkedList<Node>();
            q.add(n);
            while(q.size()>0)
            {
                Node node=q.poll();
                int x=node.x;
                int y=node.y;
                String res=node.str;
                if(arr[x][y]==target.charAt(i))
                {
                    if(i==target.length()-1)
                    {
                        return res+"!";
                    }
                    
                    n=new Node(x,y,res+"!");
                    break;
                }
                else
                {
                    if(x-1>=0 && visited[x-1][y]==0 && arr[x-1][y]>='a' && arr[x-1][y]<='z')
                    {
                        visited[x-1][y]=1;
                        q.add(new Node(x-1,y,res+"U"));
                    }
                    if(x+1<arr.length && visited[x+1][y]==0 && arr[x+1][y]>='a' && arr[x+1][y]<='z')
                    {
                        visited[x+1][y]=1;
                        q.add(new Node(x+1,y,res+"D"));
                    }
                    if(y-1>=0 && visited[x][y-1]==0 && arr[x][y-1]>='a' && arr[x][y-1]<='z')
                    {
                        visited[x][y-1]=1;
                        q.add(new Node(x,y-1,res+"L"));
                    }
                    if(y+1<arr[0].length && visited[x][y+1]==0 && arr[x][y+1]>='a' && arr[x][y+1]<='z')
                    {
                        visited[x][y+1]=1;
                        q.add(new Node(x,y+1,res+"R"));
                    }
                }
            }
            
        }

        return "";
    }
}
