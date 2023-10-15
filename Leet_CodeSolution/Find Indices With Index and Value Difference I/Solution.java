class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int result[]={-1,-1};
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j-i>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference)
                {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        
        return result;
    }
}
