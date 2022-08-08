class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,j=0;
        HashSet<Integer> h=new HashSet<Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        int sum=0,max=0;
        while(j<nums.length)
        {
            if(!h.contains(nums[j]))
            {
                sum=sum+nums[j];
                h.add(nums[j]);
                l.add(nums[j]);
            }
            else
            {
                if(sum>max)
                {
                    max=sum;
                }
                
                Iterator<Integer> itr=h.iterator();
                int k=l.indexOf(nums[j]);
                for(int r=0;r<=k;r++)
                {
                    int x=l.get(0);
                    l.remove(0);
                    h.remove(0);
                    sum=sum-x;
                }
               
                sum+=nums[j];
                h.add(nums[j]);
                l.add(nums[j]);
                
            }
            
            j++;
        }
        if(sum>max)
        {
            max=sum;
        }
        
        return max;
    }
}
