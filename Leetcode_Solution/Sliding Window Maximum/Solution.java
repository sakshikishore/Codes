class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int j=0;
        int result[]=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
                if(dq.size()==0)
                {
                    dq.add(nums[i]);
                }
                else if(dq.getLast()<nums[i])
                {
                    dq.pollLast();
                    while(dq.size()>0 && dq.getLast()<nums[i])
                    {
                        dq.pollLast();
                    }
                    dq.add(nums[i]);
                }
                else
                {
                    dq.add(nums[i]);
                }
            }
            else
            {
                result[j]=dq.getFirst();
                if(dq.getFirst()==nums[j])
                {
                   dq.poll(); 
                }
                j++;
                if(dq.size()==0)
                {
                    dq.add(nums[i]);
                }
                else if(dq.getLast()<nums[i])
                {
                    dq.pollLast();
                    while(dq.size()>0 && dq.getLast()<nums[i])
                    {
                        dq.pollLast();
                    }
                    dq.add(nums[i]);
                }
                else
                {
                    dq.add(nums[i]);
                }
                
            }
        }
        
        result[j]=dq.getFirst();
        
        return result;
        
        
    }
}
