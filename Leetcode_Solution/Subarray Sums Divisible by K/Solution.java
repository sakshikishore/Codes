class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(0,1);
        long sum=0;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            long rem=sum%k;
            int x=(int)rem;
            if(x<0)
            {
                x=k+x;
            }
            if(!h.containsKey(x))
            {
                h.put(x,1);
            }
            else
            {
                h.put(x,h.get(x)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int val=entry.getValue();
            if(val>1)
            {
                result+=((val)*(val-1))/2;
            }

        }
      
        
        return result;
    }
}
