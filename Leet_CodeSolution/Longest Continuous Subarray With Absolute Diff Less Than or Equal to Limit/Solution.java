class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int result=1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(nums[0]);
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(nums[0],0);
        int start=0;
        for(int i=1;i<nums.length;i++)
        {
            if(i==1)
            {
                if(Math.abs(nums[i]-nums[0])>limit)
                {
                    l.remove(0);
                    l.add(nums[i]);
                }
                else
                {
                    result=2;
                    if(nums[i]<nums[0])
                    {
                        l.add(0,nums[i]);
                    }
                    else
                    {
                        l.add(nums[i]);
                    }
                }
                h.put(nums[i],i);
            }
            else
            {
                int index=-1;
                if(nums[i]>l.get(l.size()-1))
                {
                     int p=0;
                     while(p<l.size() && nums[i]-l.get(p)>limit)
                     {
                         if(h.get(l.get(p))>index)
                         {
                             index=h.get(l.get(p));
                         }
                         p++;
                     }
                     if(index!=-1)
                     {
                         for(int k=start;k<=index;k++)
                         {
                             int low=0,high=l.size()-1;
                             while(low<=high)
                             {
                                 int mid=(low+high)/2;
                                 if(l.get(mid)==nums[k])
                                 {
                                     l.remove(mid);
                                     break;
                                 }
                                 else if(l.get(mid)>nums[k])
                                 {
                                     high=mid-1;
                                 }
                                 else
                                 {
                                     low=mid+1;
                                 }
                             }
                         }
                         start=index+1;
                     }
                     l.add(nums[i]);
                     h.put(nums[i],i);
                     if(l.size()>result)
                     {
                         result=l.size();
                     }
                }
                else if(nums[i]<l.get(0))
                {
                    index=-1;
                    if(l.get(l.size()-1)-nums[i]>limit)
                    {
                        int p=l.size()-1;
                        while(p>=0 && l.get(p)-nums[i]>limit)
                        {
                           if(h.get(l.get(p))>index)
                           {
                               index=h.get(l.get(p));
                           }
                           p--;
                        }
                     if(index!=-1)
                     {
                         for(int k=start;k<=index;k++)
                         {
                             int low=0,high=l.size()-1;
                             while(low<=high)
                             {
                                 int mid=(low+high)/2;
                                 if(l.get(mid)==nums[k])
                                 {
                                     l.remove(mid);
                                     break;
                                 }
                                 else if(l.get(mid)>nums[k])
                                 {
                                     high=mid-1;
                                 }
                                 else
                                 {
                                     low=mid+1;
                                 }
                             }
                         }
                         start=index+1;
                     }

                    }
                    l.add(0,nums[i]);
                    h.put(nums[i],i);
                    if(l.size()>result)
                    {
                        result=l.size();
                    }

                }
                else
                {
                    int low=0,high=l.size()-1;
                    index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>nums[i])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            index=mid+1;
                            low=mid+1;
                        }
                    }
                    l.add(index,nums[i]);
                    h.put(nums[i],i);
                    if(l.size()>result)
                    {
                        result=l.size();
                    }

                }

            }
        }

        return result;
    }
}
