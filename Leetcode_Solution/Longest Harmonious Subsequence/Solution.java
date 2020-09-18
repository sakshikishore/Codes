class Solution {
    public int findLHS(int[] nums) {
        TreeSet<Integer> t=new TreeSet<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            t.add(nums[i]);
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
        
        Iterator<Integer> itr=t.iterator();
        int count=0;
        int prev=0;
        int max=0;
        while(itr.hasNext())
        {
            if(count==0)
            {
               prev=itr.next();
            }
            else
            {
                int q=itr.next();
                if((q-prev)==1)
                {
                    int sum=h.get(prev)+h.get(q);
                    if(sum>max)
                    {
                        max=sum;
                    }
                }
                prev=q;
            }
            count++;
        }
        
        return max;
        
    }
}
