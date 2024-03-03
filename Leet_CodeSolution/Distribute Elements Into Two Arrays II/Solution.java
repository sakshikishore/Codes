class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        ArrayList<Integer> l3=new ArrayList<Integer>();
         ArrayList<Integer> l4=new ArrayList<Integer>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        l3.add(nums[0]);
        l4.add(nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            int low=0,high=l1.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l1.get(mid)>nums[i])
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
            int g1=l1.size()-index;
            low=0;
            high=l2.size()-1;
            int index1=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l2.get(mid)>nums[i])
                {
                    index1=mid;
                    high=mid-1;
                }
                else
                {
                    index1=mid+1;
                    low=mid+1;
                }
            }
            int g2=l2.size()-index1;
            if(g1>g2)
            {
                l1.add(index,nums[i]);
                l3.add(nums[i]);
            }
            else if(g1<g2)
            {
                l2.add(index1,nums[i]);
                l4.add(nums[i]);
            }
            else
            {
                if(l1.size()<=l2.size())
                {
                    l1.add(index,nums[i]);
                    l3.add(nums[i]);
                }
                else
                {
                    l2.add(index1,nums[i]);
                    l4.add(nums[i]);
                }
            }
            
        }
        int result[]=new int[nums.length];
        int j=0;
        for(int i=0;i<l1.size();i++)
        {
            result[j]=l3.get(i);
            j++;
        }
        for(int i=0;i<l2.size();i++)
        {
            result[j]=l4.get(i);
            j++;
        }
        
        return result;
        
    }
}
