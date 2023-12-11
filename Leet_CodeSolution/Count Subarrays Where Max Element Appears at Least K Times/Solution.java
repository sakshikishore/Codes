class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max=0;
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]>max)
           {
               max=nums[i];
           }
       }
        ArrayList<Integer> l=new ArrayList<Integer>();
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]==max)
           {
               l.add(i);
           }
       }
        if(l.size()<k)
        {
            return 0;
        }
        else
        {
            int index=l.get(k-1);
            long result=(l.get(0)+1);
            result=result*(nums.length-index);
            int j=0;
            for(int i=k;i<l.size();i++)
            {
                long p=l.get(j+1)-l.get(j);
                result+=p*(nums.length-l.get(i));
                j++;
            }
            
            return result;
        }
    }
}
