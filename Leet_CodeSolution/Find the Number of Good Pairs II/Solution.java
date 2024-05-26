class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Long,Long> h=new HashMap<Long,Long>();
        long max=0;
        long result=0;
        for(int i=0;i<nums2.length;i++)
        {
           long p=nums2[i]*1l;
           p=p*k;
            if(!h.containsKey(p))
            {
                h.put(p,1L);
            }
            else
            {
                h.put(p,h.get(p)+1);
            }
        }
        HashMap<Long,Long> h2=new HashMap<Long,Long>();
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]>max)
            {
                max=nums1[i];
            }
           if(!h2.containsKey(nums1[i]*1L))
           {
               h2.put(nums1[i]*1L,1L);
           }
           else
           {
               h2.put(nums1[i]*1L,h2.get(nums1[i]*1L)+1);
           }
        }
        for(Map.Entry<Long,Long> entry:h.entrySet())
        {
            long key=entry.getKey();
            long val=entry.getValue();
            for(long i=key;i<=max;i=i+key)
            {
                if(h2.containsKey(i))
                {
                    long x=h2.get(i);
                    result+=(val*x);
                }
            }
        }
        
        return result;
    }
}
