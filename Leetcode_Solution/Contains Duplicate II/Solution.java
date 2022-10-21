class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],i);
            }
            else
            {
                int x=h.get(nums[i]);
                if(i-x<=k)
                {
                    return true;
                }
                h.put(nums[i],i);
            }
        }
        
        return false;
    }
}
