class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                result[0]++;
                h.remove(nums[i]);
            }
        }
        
        result[1]=nums.length-(result[0]*2);
        
        return result;
    }
}
