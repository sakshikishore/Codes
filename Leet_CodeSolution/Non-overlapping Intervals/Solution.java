class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int result=0;
        for(int i=0;i<intervals.length;i++)
        {
            if(!h.containsKey(intervals[i][0]))
            {
                pq.add(intervals[i][0]);
                h.put(intervals[i][0],intervals[i][1]);
            }
            else
            {
                result++;
                if(h.get(intervals[i][0])>intervals[i][1])
                {
                     h.put(intervals[i][0],intervals[i][1]);
                }
            }
        }
        if(h.size()==1)
        {
            return result;
        }
        else
        {
            int start=pq.poll();
            int end=h.get(start);
            while(pq.size()>0)
            {
                int x=pq.poll();
                int xEnd=h.get(x);
                if(end>x)
                {
                    result++;
                    if(xEnd<=end)
                    {
                        start=x;
                        end=xEnd;
                    }
                }
                else
                {
                        start=x;
                        end=xEnd; 
                }
            }
        }

        return result;

    }
}
