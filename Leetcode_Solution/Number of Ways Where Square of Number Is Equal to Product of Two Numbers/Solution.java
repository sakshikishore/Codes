class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
         HashMap<Long,Integer> h1=new HashMap<Long,Integer>();
         HashMap<Long,Integer> h2=new HashMap<Long,Integer>();
         int count=0;
        for(int i=0;i<nums1.length;i++)
        {
            long x=1;
            x=x*nums1[i]*nums1[i];
            if(!h1.containsKey(x))
            {
                h1.put(x,1);
            }
            else
            {
                h1.put(x,h1.get(x)+1);
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            for(int j=i+1;j<nums2.length;j++)
            {
                long x=1;
                x=x*nums2[i]*nums2[j];
                if(h1.containsKey(x))
                {
                    count+=h1.get(x);
                }
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            long x=1;
             x=x*nums2[i]*nums2[i];

            if(!h2.containsKey(x))
            {
                h2.put(x,1);
            }
            else
            {
                h2.put(x,h2.get(x)+1);
            }
        }
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=i+1;j<nums1.length;j++)
            {
                long y=1;
                y=y*nums1[i]*nums1[j];
                if(h2.containsKey(y))
                {
                    count+=h2.get(y);
                }
            }
        }
       
        return count;
    }
}
