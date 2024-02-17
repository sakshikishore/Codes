class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=1;i<heights.length;i++)
        {
            if(heights[i]<heights[i-1])
            {
                continue;
            }
            else
            {
                int diff=bricks-(heights[i]-heights[i-1]);
                if(diff<0)
                {
                    while(pq.size()>0 && bricks-(heights[i]-heights[i-1])<0 && ladders>0 && pq.peek()>(heights[i]-heights[i-1]))
                    {
                        int x=pq.poll();
                        bricks=bricks+x;
                        ladders--;
                    }
                    if(bricks-(heights[i]-heights[i-1])>=0)
                    {
                        pq.add(heights[i]-heights[i-1]);
                        bricks=bricks-(heights[i]-heights[i-1]);
                    }
                    else if(ladders!=0)
                    {
                        ladders--;
                    }
                    else
                    {
                        
                        return i-1;
                    }
                }
                else
                {
                    pq.add(heights[i]-heights[i-1]);
                    bricks=bricks-(heights[i]-heights[i-1]);
                }
            }
        }

        return heights.length-1;
    }
}
