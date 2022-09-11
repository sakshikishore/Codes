class Solution {
    public int mostFrequentEven(int[] nums) {
        int max=0,result=-1;
        int arr[]=new int[100001];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                arr[nums[i]]++;
                if(arr[nums[i]]>max)
                {
                    max=arr[nums[i]];
                    result=nums[i];
                }
                else if(arr[nums[i]]==max)
                {
                    if(result>nums[i])
                    {
                        result=nums[i];
                    }
                }
            }
        }
        
        return result;
    }
}
