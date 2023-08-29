class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int visited[][]=new int[mat.length][mat[0].length];
        int distance[][]=new int[mat.length][mat[0].length];
        Queue<ArrayList<Integer>> q=new LinkedList<ArrayList<Integer>>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    visited[i][j]=1;
                    distance[i][j]=0;
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(j);
                    l.add(0);
                    q.add(l);
                }
            }
        }
        while(q.size()>0)
        {
            ArrayList<Integer> l=q.poll();
            int x=l.get(0);
            int y=l.get(1);
            if(x-1>=0 && visited[x-1][y]!=1)
            {
                visited[x-1][y]=1;
                distance[x-1][y]=l.get(2)+1;
                ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(x-1);
                    al.add(y);
                    al.add(distance[x-1][y]);
                    q.add(al);
            }
             if(y-1>=0 && visited[x][y-1]!=1)
            {
                visited[x][y-1]=1;
                distance[x][y-1]=l.get(2)+1;
                ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(x);
                    al.add(y-1);
                    al.add(distance[x][y-1]);
                    q.add(al);
            }
             if(x+1<mat.length && visited[x+1][y]!=1)
            {
                visited[x+1][y]=1;
                distance[x+1][y]=l.get(2)+1;
                ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(x+1);
                    al.add(y);
                    al.add(distance[x+1][y]);
                    q.add(al);
            }
             if(y+1<mat[0].length && visited[x][y+1]!=1)
            {
                visited[x][y+1]=1;
                distance[x][y+1]=l.get(2)+1;
                ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(x);
                    al.add(y+1);
                    al.add(distance[x][y+1]);
                    q.add(al);
            }
        }

        return distance;
    }
}
