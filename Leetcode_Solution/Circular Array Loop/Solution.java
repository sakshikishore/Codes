class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int p=0;
        boolean result=false;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            if(nums[i]>0)
            {
                p=i;
                int r=p;
                int flag=0;
                while(flag!=1)
                {
                    int l=(r+nums[r])%nums.length;
                    if(nums[l]>0)
                    {
                        
                        r=l;
                        System.out.println(r+" "+p);
                        if(r!=p)
                        {
                            count++;
                        }
                        if(r==p && count>0)
                        {
                            result=true;
                            break;
                        }
                        else if(r==p && count==0)
                        {
                            break;
                        }
                        else if(count>nums.length)
                        {
                            break;
                        }
                    }
                    else
                    {
                        break;
                    }
                }
            }
            else
            {
                p=i;
                int r=p;
                int flag=0;
                while(flag!=1)
                {
                    int l=(nums.length+r+nums[r])%nums.length;
                    if(l<0)
                    {
                        l=nums.length-(-1*l);
                    }
                    if(nums[l]<0)
                    {
                        r=l;
                        if(r!=p)
                        {
                            count++;
                        }
                        if(r==p && count>0)
                        {
                            result=true;
                            break;
                        }
                        else if(r==p && count==0)
                        {
                            break;
                        }
                        else if(count>nums.length)
                        {
                            break;
                        }
                    }
                    else
                    {
                        break;
                    }
                }
                
            }
            
            if(result==true)
            {
                break;
            }
        }
        
        return result;
    }
}
