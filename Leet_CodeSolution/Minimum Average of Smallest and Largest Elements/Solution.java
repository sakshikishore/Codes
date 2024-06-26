class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        float min=(nums[0]+nums[nums.length-1]);
        min=min/2;
        int i=1,j=nums.length-2;
        while(i<j)
        {
            float avg=(nums[i]+nums[j]);
            avg=avg/2;
            if(avg<min)
            {
               min=avg; 
            }
            i++;
            j--;
        }
        
        return min;
    }
}
