class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
       List<List<Long>> result=new ArrayList();
       long arr[]=new long[100001];
       HashSet<Integer> hset=new HashSet<Integer>();
       PriorityQueue<Integer> pq=new PriorityQueue<Integer> ();
       for(int i=0;i<segments.length;i++)
       {
           arr[segments[i][0]]+=segments[i][2];
           arr[segments[i][1]]-=segments[i][2];
           if(!hset.contains(segments[i][0]))
           {
                hset.add(segments[i][0]);
                pq.add(segments[i][0]);
           }
           if(!hset.contains(segments[i][1]))
           {
                hset.add(segments[i][1]);
                pq.add(segments[i][1]);
           }
       }
       for(int i=1;i<arr.length;i++)
       {
          arr[i]=arr[i-1]+arr[i];
       }
       int x=pq.poll();
       while(pq.size()>0)
       {
           int y=pq.poll();
           if(arr[y-1]!=0)
           {
                ArrayList<Long> l=new ArrayList<Long>();
                l.add(x*1l);
                l.add(y*1l);
                l.add(arr[y-1]);
                result.add(l);
           }
           x=y;
       }

       return result;
    }
}
