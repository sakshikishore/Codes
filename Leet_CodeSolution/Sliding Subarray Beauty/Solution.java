class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int n=nums.length;
        int result[]=new int[n - k + 1 ];
        for(int i=0;i<k;i++)
        {
            l.add(nums[i]);
        }
        Collections.sort(l);
        if(l.get(x-1)<0)
        {
             result[0]=l.get(x-1);
        }
        int p=0;
        for(int i=k;i<n;i++)
        {
            int low=0,high=k-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)==nums[p])
                {
                    l.remove(mid);
                    break;
                }
                else if(l.get(mid)>nums[p])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            
            // Insert Current Element
            low=0;
            high=k-2;
            int index=0;
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
            p++;
            if(l.get(x-1)<0)
            {
                result[p]=l.get(x-1);
            }
        }
        
        return result;
    }
}
