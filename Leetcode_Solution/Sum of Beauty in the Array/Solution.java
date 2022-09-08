class Solution {
    public int sumOfBeauties(int[] nums) {
        int max[]=new int[nums.length];
        int maxValue=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>maxValue)
            {
                maxValue=nums[i];
            }
             max[i]=maxValue;
        }
        int min[]=new int[nums.length];
        int minValue=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]<minValue)
            {
                minValue=nums[i];
            }
            min[i]=minValue;
        }
        int sum=0;
        for(int i=1;i<nums.length-1;i++)
        {
            if(max[i-1]<nums[i] && nums[i]<min[i+1])
            {
                sum+=2;
            }
            else if(nums[i-1]<nums[i] && nums[i]<nums[i+1])
            {
                sum+=1;
            }
        }
        
        return sum;
    }
}
