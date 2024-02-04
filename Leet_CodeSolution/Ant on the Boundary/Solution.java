class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int pos=0,count=0;
        for(int i=0;i<nums.length;i++)
        {
            pos+=nums[i];
            if(pos==0)
            {
                count++;
            }
        }
        
        return count;
    }
}
