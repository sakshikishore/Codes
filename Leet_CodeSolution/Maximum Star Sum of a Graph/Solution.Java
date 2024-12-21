class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int arr[]=new int[vals.length];
        List<PriorityQueue<Integer>> list=new ArrayList();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<vals.length;i++)
        {
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
            arr[i]=vals[i];
            list.add(pq);
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        if(k==0)
        {
            return max;
        }
        for(int i=0;i<edges.length;i++)
        {
           int x=edges[i][0];
           int y=edges[i][1];
           if(list.get(x).size()<k)
           {
            if(vals[y]>0)
            {
                list.get(x).add(vals[y]);
                arr[x]+=vals[y];
            }
           }
           else
           {
             if(list.get(x).peek()<vals[y])
             {
                int p= list.get(x).poll();
                arr[x]=arr[x]-p;
                list.get(x).add(vals[y]);
                 arr[x]+=vals[y];

             }
           }

           if(list.get(y).size()<k)
           {
            if(vals[x]>0)
            {
                list.get(y).add(vals[x]);
                arr[y]+=vals[x];
            }
           }
           else
           {
             if(list.get(y).peek()<vals[x])
             {
                int p= list.get(y).poll();
                arr[y]=arr[y]-p;
                list.get(y).add(vals[x]);
                 arr[y]+=vals[x];
             }
           }

           if(arr[x]>max)
           {
            max=arr[x];
           }
           if(arr[y]>max)
           {
            max=arr[y];
           }
        }

        return max;
    }
}
