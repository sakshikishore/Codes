class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        long ans[]=new long[nums.length];
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        ArrayList<Long> l=new ArrayList<Long>();
        for(int i=0;i<nums.length;i++)
        {
                if(!h.containsKey(nums[i]))
                {
                    h.put(nums[i],freq[i]*1L);
                    int low=0,high=l.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>freq[i])
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
                    
                    l.add(index,freq[i]*1L);
                    
                }
                else
                {
                    long prevFreq=h.get(nums[i]);
                    h.put(nums[i],prevFreq+freq[i]);
                   int low=0,high=l.size()-1;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)==prevFreq)
                        {
                            l.remove(mid);
                            break;
                        }
                        if(l.get(mid)>prevFreq)
                        {
                            high=mid-1;
                        }
                        else
                        {

                            low=mid+1;
                        }
                    }
                    if(h.get(nums[i])==0)
                    {
                        h.remove(nums[i]);
                    }
                    else
                    {
                            low=0;
                            high=l.size()-1;
                            int index=0;
                            while(low<=high)
                            {
                               int mid=(low+high)/2;
                                if(l.get(mid)>h.get(nums[i]))
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

                            l.add(index,h.get(nums[i]));
                    }
                }
            if(l.size()==0)
            {
                ans[i]=0;
            }
            else
            {
                ans[i]=l.get(l.size()-1);
            }
    }
        
        return ans;
            
    }
}
