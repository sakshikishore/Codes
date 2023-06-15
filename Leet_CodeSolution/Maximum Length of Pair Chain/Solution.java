class Solution {
    public int findLongestChain(int[][] pairs) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<pairs.length;i++)
        {
            if(!h.containsKey(pairs[i][0]))
            {
                h.put(pairs[i][0],pairs[i][1]);
                pq.add(pairs[i][0]);
            }
            else
            {
                if(pairs[i][1]<h.get(pairs[i][0]))
                {
                    h.put(pairs[i][0],pairs[i][1]);
                }
            }
        }

        if(pq.size()==1)
        {
            return 1;
        }
        else
        {
            int start=pq.poll();
            int end=h.get(start);
            int result=1;
            while(pq.size()>0)
            {
                int x=pq.poll();
                int xEnd=h.get(x);
                if(x>end)
                {
                    result++;
                    start=x;
                    end=xEnd;
                }
                else
                {
                    if(end>xEnd)
                    {
                         start=x;
                         end=xEnd;
                    }
                }
           }

           return result;
        }
    }
}
