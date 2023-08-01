class Solution {
    public boolean checkPossibility(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<=nums[i])
                {
                    if(arr[j]+1>arr[i])
                    {
                        arr[i]=arr[j]+1;
                    }
                }
            }
        }
        if(arr[arr.length-1]>=nums.length-1 || arr[arr.length-2]>=nums.length-1)
        {
            return true;
        }
        return false;
    }
}
