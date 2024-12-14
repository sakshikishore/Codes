class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        long arr[]=new long[nums.length];
        for(int i=0;i<requests.length;i++)
        {
            arr[requests[i][0]]++;
            if(requests[i][1]<nums.length-1)
            {
                arr[requests[i][1]+1]=arr[requests[i][1]+1]-1;
            }
        }
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i];
        }
        Arrays.sort(arr);
        Arrays.sort(nums);
        int i=arr.length-1;
        long res=0;
        while(i>=0 && arr[i]!=0)
        {
            res+=arr[i]*nums[i];
            res=res%(1000000007);
            i--;
        }

        return (int)res;
    }
}
