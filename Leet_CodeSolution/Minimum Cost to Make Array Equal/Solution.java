class Solution {
    public long minCost(int[] nums, int[] cost) {
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+cost[i];
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],cost[i]*1l);
                pq.add(nums[i]);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+cost[i]);
            }
        }

        if(h.size()==1)
        {
            return 0;
        }
        long m=sum/2;
        if(sum%2!=0)
        {
            m=m+1;
        }
        long a=0;
        int p=0;
        while(pq.size()>0)
        {
            int x=pq.poll();
            a=a+h.get(x);
            if(a>=m)
            {
                p=x;
                break;
            }
        }
        long result=0;
        for(Map.Entry<Integer,Long> entry:h.entrySet())
        {
            int key=entry.getKey();
            long val=entry.getValue();
            result+=val*(Math.abs(p-key));
        }
    

       return result;

    }
}
