class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int max=0;
            int count=0;
            while(x>0)
            {
                int r=x%10;
                if(r>max)
                {
                    max=r;
                }
                count++;
                x=x/10;
            }
            int res=0;
            for(int j=0;j<count;j++)
            {
                res=res*10+max;
            }
            
            sum+=res;
            
        }
        
        return sum;
    }
}
