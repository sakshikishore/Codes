class Solution {
    public int countTriplets(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                if(!h.containsKey(0))
                {
                    h.put(0,nums.length);
                }
                else
                {
                    h.put(0,h.get(0)+nums.length);
                }
            }
            else
            {
               for(int j=0;j<nums.length;j++)
               {
                   int p=nums[i]&nums[j];
                   if(!h.containsKey(p))
                   {
                       h.put(p,1);
                   }
                   else
                   {
                       h.put(p,h.get(p)+1);
                   }
               }
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            for(Map.Entry<Integer,Integer> entry:h.entrySet())
            {
                int key=entry.getKey();
                if((key & nums[i])==0)
                {
                    count=count+entry.getValue();
                }
                
            }
        }
        
        return count;
    }
}
