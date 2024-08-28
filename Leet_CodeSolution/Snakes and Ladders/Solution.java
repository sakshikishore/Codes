class Node
{
    int x,y;
    public Node(int a, int b)
    {
        x=a;
        y=b;
    }
}
class Solution {
    int min=Integer.MAX_VALUE;
    int p=1;
    HashMap<Integer,Node> h=new HashMap<Integer,Node>();
    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    public void Solve(int[][] board,int num,int count)
    {
        if(num==p-1)
        {
            if(count<min)
            {
                min=count;
            }
        }
        if(!map.containsKey(num))
        {
           map.put(num,count);
        }
        else
        {
            if(map.get(num)>count)
            {
                map.put(num,count);
            }
            else
            {
                return;
            }
        }
        for(int k=1;k<=6;k++)
        {
            if(num+k<p)
            {
                Node node=h.get(num+k);
                int a=node.x;
                int b=node.y;
                if(board[a][b]==-1)
                {
                Solve(board,num+k,count+1);
                }
                else
                {
                    Solve(board,board[a][b],count+1);
                }
            }
        }
    }
    public int snakesAndLadders(int[][] board) {
        int k=0;
        for(int i=board.length-1;i>=0;i--)
        {
            if(k%2==0)
            {
                for(int j=0;j<board[0].length;j++)
                {
                    h.put(p,new Node(i,j));
                    p++;
                }
            }
            else
            {
                for(int j=board[0].length-1;j>=0;j--)
                {
                    h.put(p,new Node(i,j));
                    p++;
                } 
            }
            k++;
        }
        Solve(board,1,0);
        if(min==Integer.MAX_VALUE)
        {
            return -1;
        }

        return min;
    }
}
