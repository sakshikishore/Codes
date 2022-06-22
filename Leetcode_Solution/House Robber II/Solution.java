class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int arr1[]=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++)
        {
            if(i==0 || i==1)
            {
                arr1[i]=nums[i];
            }
            else if(i==2)
            {
                arr1[i]=nums[i]+arr1[0];
            }
            else
            {
                arr1[i]=nums[i]+Math.max(arr1[i-2],arr1[i-3]);
            }
        }
        int max1=Math.max(arr1[arr1.length-1],arr1[arr1.length-2]);
        int arr2[]=new int[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            if(i==1 || i==2)
            {
                arr2[i-1]=nums[i];
            }
            else if(i==3)
            {
                arr2[i-1]=nums[i]+arr2[0];
            }
            else
            {
                arr2[i-1]=nums[i]+Math.max(arr2[i-2-1],arr2[i-3-1]);
            }
        }
        int max2=Math.max(arr2[arr2.length-1],arr2[arr2.length-2]);
        
        return Math.max(max1,max2);
    }
}
