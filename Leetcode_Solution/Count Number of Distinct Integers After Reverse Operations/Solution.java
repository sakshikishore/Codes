class Solution {
    public int countDistinctIntegers(int[] nums) {
      HashSet<Integer> h=new HashSet<Integer>();
      for(int i=0;i<nums.length;i++)
      {
          h.add(nums[i]);
      }
        Iterator<Integer> itr=h.iterator();
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(itr.hasNext())
        {
            int x=itr.next();
            int sum=0;
            while(x>0)
            {
                int r=x%10;
                sum=sum*10+r;
                x=x/10;
            }
            
            l.add(sum);
        }
        
        for(int i=0;i<l.size();i++)
        {
            h.add(l.get(i));
        }
        
        return h.size();
    }
}
