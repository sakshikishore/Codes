class Solution {
    public boolean validPartition(int[] nums) {
        int a[]=new int[nums.length];
        a[0]=-1;
        for(int i=1;i<nums.length;i++)
        {
            a[i]=-1;
            int flag=0;
            // 2 same
            if(nums[i]==nums[i-1])
            {
                if(i-2>=0)
                {
                    if(a[i-2]==1)
                    {
                        a[i]=1;
                        flag=1;
                    }
                }
                else
                {
                    a[i]=1;
                    flag=1;
                }
            }
            // 3same
            if(flag==0)
            {
                if(i>1)
                {
                    if(nums[i]==nums[i-1] && nums[i-1]==nums[i-2])
                    {
                        if(i-3>=0)
                        {
                            if(a[i-3]==1)
                            {
                                a[i]=1;
                                flag=1;
                            }
                        }
                        else
                        {
                                a[i]=1;
                                flag=1;
                        }
                    }
                }
            }
            //3 consecutive
             if(flag==0)
             {
                if(i>1)
                {
                    if(nums[i]-nums[i-1]==1 && nums[i-1]-nums[i-2]==1)
                    {
                        if(i-3>=0)
                        {
                            if(a[i-3]==1)
                            {
                                a[i]=1;
                                flag=1;
                            }
                        }
                        else
                        {
                                a[i]=1;
                                flag=1;
                        }
                    }
                }
            }
            
        }
        if(a[a.length-1]==1)
        {
            return true;
        }
        
        return false;
        
    }
}
