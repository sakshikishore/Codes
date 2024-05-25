class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashSet<Integer> hset=new HashSet<Integer>();
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!hset.contains(nums[i]))
            {
                hset.add(nums[i]);
            }
            else
            {
                ans=ans^nums[i];
            }
        }
        
        return ans;
    }
}
