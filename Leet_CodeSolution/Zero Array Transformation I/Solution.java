class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int arr[]=new int[nums.length];
        for(int i=0;i<queries.length;i++)
        {
            arr[queries[i][0]]+=1;
            if(queries[i][1]+1<=nums.length-1)
            {
                arr[queries[i][1]+1]=arr[queries[i][1]+1]-1;
            }

        }
       
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i];
           
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0 && nums[i]>arr[i])
            {
                return false;
            }
        }

        return true;
    }
}
