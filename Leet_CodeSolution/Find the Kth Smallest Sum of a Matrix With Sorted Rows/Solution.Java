class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<mat[0].length;i++)
        {
            pq.add(mat[0][i]);
            if(pq.size()==k)
            {
                break;
            }
        }
        int arr[]=new int[pq.size()];
        int y=arr.length-1;
        while(pq.size()>0)
        {
            arr[y]=pq.poll();
            y--;
        }
        for(int i=1;i<mat.length;i++)
        {
            pq=new PriorityQueue<Integer>(Collections.reverseOrder());
             for(int j=0;j<mat[0].length;j++)
             {
                for(int k1=0;k1<arr.length;k1++)
                {
                    int x=arr[k1]+mat[i][j];
                    if(pq.size()==k)
                    {
                        if(pq.peek()>x)
                        {
                            pq.poll();
                            pq.add(x);
                        }
                    }
                    else
                    {
                        pq.add(x);
                    }
                }
             }
             arr=new int[pq.size()];
             y=arr.length-1;
            while(pq.size()>0)
            {
                arr[y]=pq.poll();
                y--;
            }
        }

        return arr[k-1];
    }
}
