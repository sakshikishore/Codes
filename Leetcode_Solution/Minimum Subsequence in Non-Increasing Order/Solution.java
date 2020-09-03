class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int s=0;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=nums.length-1;i>=0;i--)
        {
            s=s+nums[i];
            sum=sum-nums[i];
            l.add(nums[i]);
            if(s>sum)
            {
                break;
            }
        }
        
        
        return l;
        
    }
}
