class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,ArrayList<Integer>> map=new  HashMap<Integer,ArrayList<Integer>>();
        long pref[]=new long[nums.length];
        long max=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                pref[i]=nums[i];
            }
            else
            {
                pref[i]=pref[i-1]+nums[i];
            }
            if(!map.containsKey(nums[i]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
            }
            else
            {
                ArrayList<Integer> list=map.get(nums[i]);
                list.add(i);
                map.put(nums[i],list);
            }
        }
        int flag=0;
        for(int i=0;i<nums.length;i++)
        {
            int p=nums[i]-k;
            int q=nums[i]+k;
            if(map.containsKey(p))
            {
                ArrayList<Integer> l=map.get(p);
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)<=i)
                    {
                        index=mid+1;
                        low=mid+1;
                    }
                    else
                    {
                        index=mid;
                        high=mid-1;
                    }
                }
                for(int j=index;j<l.size();j++)
                {
                    flag=1;
                    if(i==0)
                    {
                        if(pref[l.get(j)]>max)
                        {
                            max=pref[l.get(j)];
                        }
                    }
                    else
                    {
                        long x=pref[l.get(j)]-pref[i-1];
                        if(x>max)
                        {
                            max=x;
                        }
                    }
                }
            }
             if(map.containsKey(q))
            {
                ArrayList<Integer> l=map.get(q);
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)<=i)
                    {
                        index=mid+1;
                        low=mid+1;
                    }
                    else
                    {
                        index=mid;
                        high=mid-1;
                    }
                }
                for(int j=index;j<l.size();j++)
                {
                    flag=1;
                    if(i==0)
                    {
                        if(pref[l.get(j)]>max)
                        {
                            max=pref[l.get(j)];
                        }
                    }
                    else
                    {
                        long x=pref[l.get(j)]-pref[i-1];
                        if(x>max)
                        {
                            max=x;
                        }
                    }
                }
            }
        }
        if(flag==0)
        {
            return 0;
        }
        return max;
        
    }
}
