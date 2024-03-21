class Solution {
    public int[] getOrder(int[][] tasks) {
        int result[]=new int[tasks.length];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<tasks.length;i++)
        {
            if(!h.containsKey(tasks[i][0]))
            {
                pq.add(tasks[i][0]);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(tasks[i][0],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(tasks[i][0]);
                 l.add(i);
                 h.put(tasks[i][0],l);
            }
        }
       
       ArrayList<Integer> al=new ArrayList<Integer>();
       int i=0;
       int r=pq.peek();
       while(i<result.length)
       {
        while(pq.size()>0 && pq.peek()<=r)
        {
            int x=pq.poll();
         ArrayList<Integer> p=h.get(x);
         for(int j=0;j<p.size();j++)
         {
            int low=0,high=al.size()-1,index=0;
            while(low<=high)
            {
                 int mid=(low+high)/2;
                 if(tasks[al.get(mid)][1]>tasks[p.get(j)][1])
                 {
                    index=mid;
                    high=mid-1;
                 }
                 else if(tasks[al.get(mid)][1]==tasks[p.get(j)][1])
                 {
                    if(p.get(j)<al.get(mid))
                    {
                        index=mid;
                        high=mid-1;
                    }
                    else
                    {
                        index=mid+1;
                        low=mid+1;
                    }
                 }
                 else
                 {
                    index=mid+1;
                    low=mid+1;
                 }
            }
            al.add(index,p.get(j));
            }
         }
         if(pq.size()==0)
         {
            for(int j=0;j<al.size();j++)
            {
                result[i]=al.get(j);
                i++;
            }
         }
         else
         {
            while(al.size()>0 && (r+tasks[al.get(0)][1])<pq.peek())
            {
               r=r+tasks[al.get(0)][1];
               result[i]=al.remove(0);
               i++;
            }
            if(al.size()==0)
            {
                r=pq.peek();
            }
            else
            {
                 r=r+tasks[al.get(0)][1];
                 result[i]=al.remove(0);
                  i++;
            }
         }
       }

       return result;

    }
}
