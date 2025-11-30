class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int val[]=new int[nums.length];
        int result=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
            {
                val[i]=0;
            }
            else if(nums[i]==nums[i+1])
            {
                val[i]=val[i+1];
            }
            else
            {
                val[i]=nums.length-1-i;
            }
            if(val[i]>=k)
            {
                result++;
            }
        }

        return result;
    }
}
