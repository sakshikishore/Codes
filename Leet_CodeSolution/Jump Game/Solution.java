class Solution {
    public boolean canJump(int[] nums) {
     int x=nums.length-1;
     for(int i=nums.length-2;i>=0;i--)
     {
           if(nums[i]+i>=x)
           {
                x=i;
           }
     }

     if(x==0)
     {
        return true;
     }

     return false;
    }
}
