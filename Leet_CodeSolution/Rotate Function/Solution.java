class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int prev=0,n=nums.length-1,ans=Integer.MIN_VALUE,curr=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            curr=curr+(i*nums[i]);
        }
        if(curr>ans)
        {
            ans=curr;
        }
        prev=curr;
        for(int i=1;i<nums.length;i++)
        {
           int x=nums[n-i+1]; // element at 0 index;
           curr=prev+sum-x-(n*x);
           if(curr>ans)
           {
               ans=curr;
           }
            prev=curr;
        }

        return ans;
    }
}
