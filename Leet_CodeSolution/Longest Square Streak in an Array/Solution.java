class Solution {
    public int longestSquareStreak(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                pq.add(nums[i]);
            }
        }
        while(pq.size()>0)
        {
            int x=pq.poll();
            if(h.containsKey(x))
            {
                h.remove(x);
                int p=1;
                while(true)
                {
                    if(x>1000)     //nums[i]<=100000
                    {
                        break;
                    }
                    x=x*x;
                    if(h.containsKey(x))
                    {
                        p++;
                        h.remove(x);
                    }
                    else
                    {
                        break;
                    }
                }
                if(p>1)
                {
                    if(max<p)
                    {
                        max=p;
                    }
                }
            }

        }
        if(max==0)
        {
            return -1;
        }
        return max;
    }
}
