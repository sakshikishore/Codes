class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            for(int j=i+1;j<nums.length;j++)
            {
                int p=nums[i]+nums[j];
                int val=d-(p%d);
                val=val%d;
                if(h.containsKey(val))
                {
                    res+=h.get(val);
                }
                int r=nums[j]%d;
                if(!h.containsKey(r))
                {
                    h.put(r,1);
                }
                else
                {
                    h.put(r,h.get(r)+1);
                }
            }
        }

        return res;
    }
}
