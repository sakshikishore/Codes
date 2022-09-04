class Solution {
    public int maximumProduct(int[] nums, int k) {  
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        long result=1;
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        int i=0;
        while(i<k)
        {
            int x=pq.poll();
            if(pq.size()>0)
            {
                int p=pq.peek()-x+1;
                if(i+p>k)
                {
                    x=x+(k-i);
                    i=k;
                    pq.add(x);
                }
                else
                {
                    i=i+p;
                    x=x+p;
                    pq.add(x);
                }
            }
            else
            {
              return (x+k);
            }
        }
        while(pq.size()>0)
        {
            result=result*pq.poll();
            result=result%(1000000007);
        }
        
        return (int)result;
    }
}
