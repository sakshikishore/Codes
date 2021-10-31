class Solution {
    public int smallestEqual(int[] nums) {
        int min=-1;
        for(int i=0;i<nums.length;i++)
        {
           int p=i%10;
            if(p==nums[i] && min==-1)
            {
                min=i;
                break;
            }
        }
        
        return min;
    }
}
