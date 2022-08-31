class Solution {
    public int[] getAverages(int[] nums, int k) {
        long sum=0;
        long m=2*k+1;
        int result[]=new int[nums.length];
        for(int i=0;i<result.length;i++)
        {
            result[i]=-1;
            if(i<m)
            {
                sum=sum+nums[i];
            }
        }
        if(nums.length>=m)
        {
            int x=k;
            long avg=sum/m;
            result[x]=(int)(avg);
            int j=0;
            x++;
            int p=(int)(m);
            for(int i=p;i<nums.length;i++)
            {
                sum=sum+nums[i];
                sum=sum-nums[j];
                avg=sum/m;
                result[x]=(int)(avg);
                j++;
                x++;
            }
        }
        return result;
        
    }
}
