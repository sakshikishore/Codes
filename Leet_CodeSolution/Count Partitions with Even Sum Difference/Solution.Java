class Solution {
    public int countPartitions(int[] nums) {
        int sum=0,s1=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        for(int i=0;i<nums.length-1;i++)
        {
           s1=s1+nums[i];
           int p=sum-s1;
           if((p-s1)%2==0)
           {
            count++;
           }
        }

        return count;

    }
}
