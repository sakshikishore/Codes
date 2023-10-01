class Solution {
    public int minOperations(int[] nums) {
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
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int val=entry.getValue();
                if(val==1)
                {
                    return -1;
                }
            if(val%3==0)
            {
                count+=val/3;
            }
            else if(val%3==2)
            {
                count+=val/3;
                count++;
            }
            else
            {
                count=count+2;
                val=val-4;
                count+=val/3;
            }
        }

        return count;
    }
}
