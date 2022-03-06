class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int max=0;
        int target=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]==key)
            {
                if(!h.containsKey(nums[i]))
                {
                    h.put(nums[i],1);
                    if(max==0)
                    {
                        max=1;
                        target=nums[i];
                    }
                }
                else
                {
                   h.put(nums[i],h.get(nums[i])+1);
                   if(h.get(nums[i])>max)
                   {
                       max=h.get(nums[i]);
                       target=nums[i];
                   }
                
                }
            }
        }
        
        return target;
        
    }
}
