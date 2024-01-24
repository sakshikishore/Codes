class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        long result=0;
        list.add(nums1[nums1.length-1]-nums2[nums2.length-1]+diff);
        for(int i=nums1.length-2;i>=0;i--)
        {
            int x=nums1[i]-nums2[i];
            if(i==nums1.length-2)
            {
                if(list.get(0)>=x)
                {
                    result++;
                }
                if(list.get(0)>x+diff)
                {
                    list.add(0,x+diff);
                }
                else
                {
                    list.add(x+diff);
                }
            }
            else
            {
                int low=0,high=list.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>=x)
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
                result+=list.size()-index;
                low=0;
                high=list.size()-1;
                index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>=x+diff)
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

                list.add(index,x+diff);
              
            }
        }

        return result;

    }
}
