class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int count=0;
        int max=-1;
        for(int i=0;i<(1<<nums.length);i++)
        {
            int r=0;
            for(int j=0;j<nums.length;j++)
            {
                if((i & (1<<j))>0)
                { 
                    r=(r|nums[j]);
                }
            }
             if(r>max)
             {
                  max=r;
                  count=1;
             }
             else if(r==max)
             {
                count++;
             }
        }
        
        return count;
        
    }
}
