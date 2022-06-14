class Solution {
    public int jump(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=nums.length-2;i>=0;i--)
        {
            int j=i+1;
            int count=1;
            int min=arr[j];
            j++;
            while(j<nums.length && count<nums[i])
            {
                count++;
                if(arr[j]<min)
                {
                    min=arr[j];
                }
                j++;
            }
            arr[i]=min+1;
        }
        
        return arr[0];
    }
}
