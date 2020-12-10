class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
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
        for(int i=0;i<nums.length;i++)
        {
            int p=k-nums[i];
            if(h.containsKey(nums[i]))
            {
            if(h.get(nums[i])==1)
            {
                h.remove(nums[i]);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])-1);
            }
            
            if(h.containsKey(p))
            {
                count++;
                if(h.get(p)==1)
                {
                    h.remove(p);
                }
                else
                {
                    h.put(p,h.get(p)-1);
                }
            
            }
            }
        }
        return count;
    }
}
