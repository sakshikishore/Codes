class Solution {
    public int findMinArrowShots(int[][] points) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<points.length;i++)
        {
            if(!h.containsKey(points[i][0]))
            {
                h.put(points[i][0],points[i][1]);
                pq.add(points[i][0]);
            }
            else if(h.get(points[i][0])>points[i][1])
            {
                h.put(points[i][0],points[i][1]);
            }
        }
        if(pq.size()==1)
        {
            return 1;
        }
        int start=pq.poll();
        int end=h.get(start);
        int result=1;
        while(pq.size()>0)
        {
            int x=pq.poll();
            int xEnd=h.get(x);
            if(end<x)
            {
                start=x;
                end=xEnd;
                result++;
            }
            else
            {
                start=x;
                end=(int)Math.min(end,xEnd);
            }
        }

        return result;
    }
}
