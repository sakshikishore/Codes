class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int rev=0;
            while(x>0)
            {
                int r=x%10;
                rev=rev*10+r;
                x=x/10;
            }
            int key=nums[i]-rev;
            if(!h.containsKey(key))
            {
                h.put(key,1L);
            }
            else
            {
                h.put(key,h.get(key)+1);
            }
        }
        long result=0;
        for(Map.Entry<Integer,Long> entry:h.entrySet())
        {
            long val=entry.getValue();
            if(val>1)
            {
                result+=(val*(val-1))/2;
                result=result%(1000000007);
            }
        }
        
        return (int)result;
    }
}
