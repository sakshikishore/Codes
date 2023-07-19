class Solution {
    public int reversePairs(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                l.add(nums[i]);
            }
            else if(i==1)
            {
                if(nums[0]>2l*nums[1])
                {
                    result++;
                }
                if(nums[0]>nums[1])
                {
                    l.add(0,nums[1]);
                }
                else
                {
                    l.add(nums[1]);
                }
            }
            else
            {
                int low=0,high=l.size()-1;
                int index=-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>2l*nums[i])
                    {
                        high=mid-1;
                        index=mid;
                    }
                    else
                    {
                        low=mid+1;
                        index=mid+1;
                    }
                }
                if(index!=l.size())
                {
                     result+=l.size()-index;
                }
                low=0;
                high=l.size()-1;
                index=-1;
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
                
            }
        }

        return result;
    }
}
