class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arr[]=new int[1000001];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
               int p=nums[j]-nums[i];
                arr[p]++;
            }
        }
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            count+=arr[i];
            if(count>=k)
            {
                return i;
            }
        }
        return -1;
    }
}
