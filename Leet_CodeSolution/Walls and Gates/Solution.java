class Node
{
    int x,y,count;
    public Node(int i,int j,int c)
    {
        x=i;
        y=j;
        count=c;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Node> q=new LinkedList<Node>();
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[0].length;j++)
            {
                if(rooms[i][j]==0)
                {
                    q.add(new Node(i,j,0));
                }
            }
        }
        while(q.size()>0)
        {
            Node node=q.poll();
            int i=node.x;
            int j=node.y;
            if(i-1>=0)
            {
                if(rooms[i-1][j]!=-1 && rooms[i-1][j]>node.count+1)
                {
                    rooms[i-1][j]=node.count+1;
                    q.add(new Node(i-1,j,node.count+1));
                }
            }
            if(i+1<rooms.length)
            {
                if(rooms[i+1][j]!=-1 && rooms[i+1][j]>node.count+1)
                {
                    rooms[i+1][j]=node.count+1;
                    q.add(new Node(i+1,j,node.count+1));
                }
            }
            if(j-1>=0)
            {
                if(rooms[i][j-1]!=-1 && rooms[i][j-1]>node.count+1)
                {
                    rooms[i][j-1]=node.count+1;
                    q.add(new Node(i,j-1,node.count+1));
                }
            }
            if(j+1<rooms[0].length)
            {
                if(rooms[i][j+1]!=-1 && rooms[i][j+1]>node.count+1)
                {
                    rooms[i][j+1]=node.count+1;
                    q.add(new Node(i,j+1,node.count+1));
                }
            }

        }


    }
}
