class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int total=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int p=nums[i]*nums[j];
                if(!h.containsKey(p))
                {
                    h.put(p,1);
                }
                else
                {
                    h.put(p,h.get(p)+1);
                }
            }
        }
        
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int val=entry.getValue();
            if(val>1)
            {
                int n=val-1;
                n=((n)*(n+1))/2;
                total+=n*8;
            }
        }
        
        return total;
    }
}
