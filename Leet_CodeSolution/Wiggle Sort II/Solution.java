class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=2)
        {
            return;
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            l.add(nums[i]);
        }
            int i=0;
            int mid=(l.size()-1)/2;
            nums[i]=l.get(mid);
            nums[i+1]=l.get(l.size()-1);
            nums[i+2]=l.get(0);
            i=i+3;
            l.remove(mid);
            l.remove(0);
            l.remove(l.size()-1);
            while(l.size()>0)
            {
                nums[i]=l.get(l.size()-1);
                if(nums[i]==nums[i-1])
                {
                    if(i%2!=0)
                    {
                        for(int j=i-2;j>=0;j--)
                        {
                            if(nums[j]<nums[i-1])
                            {
                                 if(j%2!=0)
                                {
                                    int temp=nums[i-1];
                                    nums[i-1]=nums[j];
                                    nums[j]=temp;
                                    break;
                                }
                                else
                                {
                                    if(j-1>=0)
                                    {
                                        if(nums[j-1]>nums[i-1] && nums[j+1]>nums[i-1])
                                        {
                                            int temp=nums[i-1];
                                            nums[i-1]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }

                                    }
                                    else
                                    {
                                        if(nums[j+1]>nums[i-1])
                                        {
                                            int temp=nums[i-1];
                                            nums[i-1]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }
                                    }
                            }
                        }
                        }
                    }
                    else
                    {
                         for(int j=i-2;j>=0;j--)
                        {
                            if(nums[j]<nums[i])
                            { 
                                if(j%2!=0)
                                {
                                    int temp=nums[i];
                                    nums[i]=nums[j];
                                    nums[j]=temp;
                                    break;
                                }
                                else
                                {
                                    if(j-1>=0)
                                    {
                                        if(nums[j-1]>nums[i] && nums[j+1]>nums[i])
                                        {
                                            int temp=nums[i];
                                            nums[i]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }

                                    }
                                    else
                                    {
                                        if(nums[j+1]>nums[i])
                                        {
                                            int temp=nums[i];
                                            nums[i]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                l.remove(l.size()-1);
                i++;
                if(l.size()>0)
                {
                    nums[i]=l.get(0);
                 if(nums[i]==nums[i-1])
                {
                    if(i%2!=0)
                    {
                        for(int j=i-2;j>=0;j--)
                        {
                            if(nums[j]<nums[i-1])
                            {
                                 if(j%2!=0)
                                {
                                    int temp=nums[i-1];
                                    nums[i-1]=nums[j];
                                    nums[j]=temp;
                                    break;
                                }
                                else
                                {
                                    if(j-1>=0)
                                    {
                                        if(nums[j-1]>nums[i-1] && nums[j+1]>nums[i-1])
                                        {
                                            int temp=nums[i-1];
                                            nums[i-1]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }

                                    }
                                    else
                                    {
                                        if(nums[j+1]>nums[i-1])
                                        {
                                            int temp=nums[i-1];
                                            nums[i-1]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }
                                    }
                            }
                        }
                        }
                    }
                    else
                    {
                         for(int j=i-2;j>=0;j--)
                        {
                            if(nums[j]<nums[i])
                            { 
                                if(j%2!=0)
                                {
                                    int temp=nums[i];
                                    nums[i]=nums[j];
                                    nums[j]=temp;
                                    break;
                                }
                                else
                                {
                                    if(j-1>=0)
                                    {
                                        if(nums[j-1]>nums[i] && nums[j+1]>nums[i])
                                        {
                                            int temp=nums[i];
                                            nums[i]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }

                                    }
                                    else
                                    {
                                        if(nums[j+1]>nums[i])
                                        {
                                            int temp=nums[i];
                                            nums[i]=nums[j];
                                            nums[j]=temp;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                    l.remove(0);
                    i++;
                }

            }
       
    }
}
