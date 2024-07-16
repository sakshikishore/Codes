class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans=0;
        int p=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
           p=p^nums[i];
           if(!h.containsKey(p))
           {
             h.put(p,1);
           } 
           else
           {
             ans+=h.get(p);
             h.put(p,h.get(p)+1);
           }
           if(p==0)
             {
                  ans++;
             }
        }

        return ans;
    }
}
