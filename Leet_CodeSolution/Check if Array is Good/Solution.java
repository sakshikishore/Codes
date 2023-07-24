class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        if(nums.length==1)
        {
            return false;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
        for(int i=1;i<nums.length;i++)
        {
            if(!h.containsKey(i))
            {
                return false;
            }
        }
        if(h.get(nums.length-1)!=2)
        {
            return false;
        }
        
        return true;
        
    }
}
