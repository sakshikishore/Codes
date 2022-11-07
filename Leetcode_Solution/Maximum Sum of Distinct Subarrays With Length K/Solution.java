class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
     Queue<Integer> q=new LinkedList<Integer>();
        long max=0;
        long sum=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                sum=sum+nums[i];
                q.add(nums[i]);
            }
            else
            {
                while(q.size()>0 && q.peek()!=nums[i])
                {
                    int x=q.poll();
                    h.remove(x);
                    sum=sum-x;
                }
                q.poll();
                q.add(nums[i]);
            }
            if(q.size()==k)
            {
                
                if(sum>max)
                {
                    max=sum;
                }
                int y=q.poll();
                sum=sum-y;
                h.remove(y);
                
            }
        }
        
        return max;
    }
}
