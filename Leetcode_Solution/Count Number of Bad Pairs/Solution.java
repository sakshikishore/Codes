class Solution {
    public long countBadPairs(int[] nums) {
        
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        long total=nums.length;
        total=((total)*(total-1))/2;
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i]-i;
            if(!h.containsKey(x))
            {
                h.put(x,1);
            }
            else
            {
                h.put(x,h.get(x)+1);
            }
        }
        
        for(Map.Entry<Integer,Integer> entry: h.entrySet())
        {
            int val=entry.getValue();
            if(val>1)
            {
                long n=val-1;
                n=(n*(n+1))/2;
                total-=n;
                
            }
        }
        
        return total;
    }
}
