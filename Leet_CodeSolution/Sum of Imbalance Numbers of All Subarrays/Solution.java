class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length-1;i++)
        {
            int prev=0;
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(nums[i]);
            for(int j=i+1;j<nums.length;j++)
            {
                if(j==i+1)
                {
                    if(nums[i]>nums[j])
                    {
                        l.add(0,nums[j]);
                    }
                    else
                    {
                        l.add(nums[j]);
                    }
                    if(l.get(1)-l.get(0)>1)
                    {
                        result++;
                        prev=1;
                    }
                }
                else
                {
                    int index=0;
                    int low=0,high=l.size()-1;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>nums[j])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            index=mid+1;
                            low=index;
                        }
                    }
                    l.add(index,nums[j]);
                    if(index==l.size()-1)
                    {
                        if(l.get(l.size()-1)-l.get(l.size()-2)>1)
                        {
                            result+=(prev+1);
                            prev++;
                        }
                        else
                        {
                            result+=prev;
                        }
                    }
                    else if(index==0)
                    {
                        
                        if(l.get(1)-l.get(0)>1)
                        {
                            
                            result+=(prev+1);
                            prev++;
                        }
                        else
                        {
                            result+=prev;
                        }
                    }
                    else
                    {
                        int r=0;
                        if(l.get(index)-l.get(index-1)>1)
                        {
                            r++;
                        }
                        if(l.get(index+1)-l.get(index)>1)
                        {
                            r++;
                        }
                        if(l.get(index+1)-l.get(index-1)>1)
                        {
                            r--;
                        }
                        prev=prev+r;
                        result+=prev;
                    }
                }
            }
        }

        return result;
    }
}
