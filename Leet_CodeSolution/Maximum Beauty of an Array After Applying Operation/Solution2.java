class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int arr[]=new int[nums[nums.length-1]+1];
        for(int i=0;i<nums.length;i++)
        {
            int l=nums[i]-k;
            int r=nums[i]+k;
            if(l<0)
            {
                arr[0]+=1;
            }
            else
            {
                arr[l]++;
            }
            if(r<nums[nums.length-1])
            {
                arr[r+1]-=1;
            }
        }
        int max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            arr[i]+=arr[i-1];
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }

        return max;
    }
}
