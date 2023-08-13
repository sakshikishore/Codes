class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int min=Integer.MAX_VALUE;
        for(int i=x;i<nums.size();i++)
        {
            l.add(nums.get(i));
        }
        Collections.sort(l);
        int p=x;
        for(int i=0;i<nums.size()-p;i++)
        {
            int low=0,high=l.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>nums.get(i))
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
        if(index==0)
        {
            if(l.get(0)-nums.get(i)<min)
            {
                min=l.get(0)-nums.get(i);
            }

        }
        else if(index==l.size())
        {
            if(nums.get(i)-l.get(l.size()-1)<min)
            {
                min=nums.get(i)-l.get(l.size()-1);
            }
        }
        else
        {
            if(l.get(index)-nums.get(i)<min)
            {
                min=l.get(index)-nums.get(i);
            }
            if(nums.get(i)-l.get(index-1)<min)
            {
                min=nums.get(i)-l.get(index-1);
            }
        }
        low=0;
        high=l.size()-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int y=nums.get(x);
            if(l.get(mid)==y)
            {
                l.remove(mid);
                break;
            }
            else if(l.get(mid)>y)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        x++;
        
     }
        
        return min;
        
    }
}
