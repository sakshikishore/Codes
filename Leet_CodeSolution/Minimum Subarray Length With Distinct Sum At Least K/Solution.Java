class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int sum=0;
        int start=0,ans=nums.length+1;
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                sum+=nums[i];
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
            if(sum>=k)
            {
                while(start<=i && sum>=k)
                {
                    ans=Math.min(ans,i-start+1);
                    if(h.get(nums[start])>1)
                    {
                        h.put(nums[start],h.get(nums[start])-1);
                    }
                    else
                    {
                        sum=sum-nums[start];
                        h.remove(nums[start]);
                    }
                    start++;
                }
            }
        }

        if(ans==nums.length+1)
        {
            return -1;
        }
        return ans;
    }
}
