class Solution {
    public String smallestNumber(String pattern) {
        char ch[]=pattern.toCharArray();
        int nums[]=new int[pattern.length()+1];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=i+1;
        }
        
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='D')
            {
                if(nums[i]<nums[i+1])
                {
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                    int k=i;
                    while((k-1)>=0)
                    {
                        if(ch[k-1]=='D')
                        {
                            if(nums[k]>nums[k-1])
                            {
                                temp=nums[k];
                                nums[k]=nums[k-1];
                                nums[k-1]=temp;
                                k--;
                            }
                            else
                            {
                                break;
                            }
                        }
                        else
                        {
                            if(nums[k]<nums[k-1])
                            {
                                temp=nums[k];
                                nums[k]=nums[k-1];
                                nums[k-1]=temp;
                                k--;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                }
            }
            else
            {
                if(nums[i]>nums[i+1])
                {
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                    int k=i;
                    while((k-1)>=0)
                    {
                        if(ch[k-1]=='D')
                        {
                            if(nums[k]>nums[k-1])
                            {
                                temp=nums[k];
                                nums[k]=nums[k-1];
                                nums[k-1]=temp;
                                k--;
                            }
                            else
                            {
                                break;
                            }
                        }
                        else
                        {
                            if(nums[k]<nums[k-1])
                            {
                                 temp=nums[k];
                                nums[k]=nums[k-1];
                                nums[k-1]=temp;
                                k--;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                }
            }
        }
        String str="";
        for(int i=0;i<nums.length;i++)
        {
            str=str+Integer.toString(nums[i]);
        }
        return str;
    }
}
