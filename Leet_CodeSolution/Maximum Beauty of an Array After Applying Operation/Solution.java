class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max=1;
        int p=1;
        int val=nums[0]+k;   
        int j=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-k<=val)
            {
                    p++;
            }
            else
            {
                if(p>max)
                {
                    max=p;
                }
                j++;
                p=0;
                while(j<i)
                {
                    if(nums[j]+k>=nums[i]-k)
                    {
                        p=i-j+1;
                        val=nums[j]+k;
                        break;
                    }
                    j++;
                }
                if(p==0)
                {
                    p=1;
                    val=nums[i]+k;
                }
                
            }
            
        }
        if(p>max)
        {
            max=p;
        }
        
        return max;
        
    }
}
