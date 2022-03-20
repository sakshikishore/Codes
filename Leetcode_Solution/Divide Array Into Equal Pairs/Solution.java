class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        boolean result=true;
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
            if(h.get(nums[i])%2!=0)
            {
                result=false;
                break;
            }
        }
        
        return result;
    }
}
