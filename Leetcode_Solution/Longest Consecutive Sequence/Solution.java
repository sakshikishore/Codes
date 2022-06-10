class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> h=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            h.add(nums[i]);
        }
        Iterator<Integer> itr=h.iterator();
        int count=0,total=0;
        int max=0;
        int prev=-1;
        while(itr.hasNext())
        {
            if(count==0)
            {
                prev=itr.next();
                total=1;
                count++;
            }
            else
            {
                int x=itr.next();
                if(x-prev==1)
                {
                    total++;
                }
                else
                {
                    if(max<total)
                    {
                        max=total;
                    }
                    total=1;
                    
                }
                prev=x;
            }
        }
        
        if(max<total)
        {
            max=total;
        }
        
        return max;
        
    }
}
