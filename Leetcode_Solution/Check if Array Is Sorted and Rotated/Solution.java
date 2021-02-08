class Solution {
    public boolean check(int[] nums) {
        int min=nums[0];
        int index=0;
        boolean result=true;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
                index=i;
            }
        }    
        if(index==0 && nums[nums.length-1]==nums[index] && nums.length>1)
        {
         
            int p=nums.length-2;
            while(nums[p]==nums[index] && p!=0)
            {
                p--;
            }
            
            for(int i=1;i<=p;i++)
            {
                
                if(nums[i]<nums[i-1])
                {
                    result=false;
                    break;
                }
            }
            if(result==false)
            {
                result=true;
                for(int i=p;i>0;i--)
                {
                    if(nums[i]>nums[i-1])
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        else
        {
        for(int i=index+1;i<nums.length+index;i++)
        {
            if(nums[i%nums.length]<nums[(i-1)%nums.length])
            {
                result=false;
                break;
            }
        }
        if(result==false)
        {
            result=true;
            for(int i=index-1+nums.length;i>index;i--)
            {
                if(nums[i%nums.length]<nums[(i+1)%nums.length])
                {
                    result=false;
                    break;
                }
            }
        }
        }
        
        return result;
    }
}
