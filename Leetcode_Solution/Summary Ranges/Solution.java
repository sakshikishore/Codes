class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> l=new ArrayList<String>();
        if(nums.length>1)
        {
        String p="";
        String q="";
        for(int i=0;i<nums.length-1;i++)
        {
            if(i==0)
            {
                p=Integer.toString(nums[i]);
            }
            if((nums[i+1]-nums[i])!=1)
            {
                q=Integer.toString(nums[i]);
                if(q.equals(p))
                {
                    l.add(p);
                }
                else
                {
                    l.add(p+"->"+q);
                }
                
                p=Integer.toString(nums[i+1]);
                
            }
        }
        q=Integer.toString(nums[nums.length-1]);
        if(p.equals(q))
        {
            l.add(p);
        }
        else
        {
            l.add(p+"->"+q);
        }
        }
        if(nums.length==1)
        {
            l.add(Integer.toString(nums[0]));
        }
        
        return l;
    }
}
