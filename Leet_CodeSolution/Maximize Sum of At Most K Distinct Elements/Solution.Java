class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!hset.contains(nums[i]))
            {
                if(pq.size()<k)
                {
                    pq.add(nums[i]);
                }
                else
                {
                  if(pq.peek()<nums[i])
                    {
                       pq.poll();
                       pq.add(nums[i]);     
                    }

                }
                hset.add(nums[i]);
            }
        }
        int res[]=new int[pq.size()];
        int j=res.length-1;
        while(pq.size()>0)
        {
            res[j]=pq.poll();
            j--;
        }

        return res;
    }
}
