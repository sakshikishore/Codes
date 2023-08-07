class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size()<3)
        {
            return true;
        }
        int x=nums.size()/2;
        for(int i=1;i<nums.size();i++)
        {
            if(nums.get(i)+nums.get(i-1)>=m)
            {
                return true;
            }
        }
        
        return false;
        
    }
}
