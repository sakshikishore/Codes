class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int result=0;
        Arrays.sort(nums);
        int i=0,j=nums.length/2;
        int k=j;
        while(j<nums.length)
        {
            if(i==k)
            {
                break;
            }
                if(2*nums[i]<=nums[j])
                {
                    result+=2;
                    i++;
                    j++;
                }
                else
                {
                    j++;
                }
            }
        

        return result;
    }
}
