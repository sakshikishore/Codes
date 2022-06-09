class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int arr[]=new int[nums.length];
        arr[0]=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                arr[i]=arr[i-1];
            }
            else
            {
                arr[i]=arr[i-1]+1;
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            result+=arr[i];
        }
        
        return result;
    }
}
