class Solution {
    public int arraySign(int[] nums) {
        int result=1;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                result=0;
                break;
            }
            else if(nums[i]<0)
            {
                count++;
            }
        }
        if(result!=0 && count%2!=0)
        {
            result=-1;
        }
        return result;
    }
}
