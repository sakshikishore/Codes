class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int nearest=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    int p=nums[i]+nums[j]+nums[k];
                    if(Math.abs(p-target)<nearest)
                                   {
                                      nearest=Math.abs(p-target);
                                      result=p;
                                   }
                }
            }
        }
        
                                   return result;
    }
}
