class Solution {
    public int searchInsert(int[] nums, int target) {
        int position=0;
        int l=0;
        if(nums[0]<target)
        {
            l++;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                position=i;
                break;
            }
            else if(nums[i]>target)
            {
                position=i;
                break;
            }
            
        }
        }
        if(l==1 && position==0)
        {
            position=nums.length;
        }
        
        return position;
    }
}
