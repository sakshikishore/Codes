class Solution {
    public void nextPermutation(int[] nums) {
        int flag=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                flag=1;
                int ans=i+1;
                for(int j=i+2;j<nums.length;j++)
                {
                    if(nums[i]<nums[j] && nums[j]<nums[ans])
                    {
                        ans=j;
                    }
                }

                 int temp=nums[i];
                 nums[i]=nums[ans];
                 nums[ans]=temp;
                 Arrays.sort(nums,i+1,nums.length);
                 break;
            }

        }

        if(flag==0)
        {
            Arrays.sort(nums);
        }

    }
}
