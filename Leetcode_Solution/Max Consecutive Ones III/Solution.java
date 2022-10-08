class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        if(k==0)
        {
            int count=0;
            
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==1)
                {
                    count++;
                }
                else
                {
                    if(count>max)
                    {
                        max=count;
                    }
                    count=0;
                }
            }
            if(count>max)
            {
                max=count;
            }
            return max;
        }
        Queue<Integer> q=new LinkedList<Integer>();
        int startIndex=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                if(q.size()==k)
                {
                    int x=q.poll();
                    if(i-startIndex>max)
                    {
                        max=i-startIndex;
                    }
                    q.add(i);
                    startIndex=x+1;
                }
                else
                {
                    q.add(i);
                }
            }
        }
        if(nums.length-startIndex>max)
        {
            max=nums.length-startIndex;
        }
        
        return max;
    }
}
