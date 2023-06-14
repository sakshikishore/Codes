class Solution {
    public int getMaxLen(int[] nums) {
        int start=-1;
        int result=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                if(start!=-1)
                {
                    if(l.size()%2==0)
                    {
                        if(i-start>result)
                        {
                            result=i-start;
                        }
                    }
                    else
                    {
                    int p=l.get(l.size()-1);
                    int q=l.get(0);
                    if(p-start>result)
                    {
                        result=p-start;
                    }
                    if((i-(q+1))>result)
                    {
                        result=i-(q+1);
                    }
                    }
                    start=-1;
                    l=new ArrayList<Integer>();
                }
            }
            else
            {
                if(nums[i]<0)
                {
                    l.add(i);
                }
                if(start==-1)
                {
                    start=i;
                }
            }
        }
        if(start!=-1)
        {
               if(l.size()%2==0)
                {
                   if(nums.length-start>result)
                        {
                            result=nums.length-start;
                        }
                }
                else
                {
                    int p=l.get(l.size()-1);
                    int q=l.get(0);
                    if(p-start>result)
                    {
                        result=p-start;
                    }
                    if((nums.length-(q+1))>result)
                    {
                        result=nums.length-(q+1);
                    }
                }
        }

        return result;
    }
}
