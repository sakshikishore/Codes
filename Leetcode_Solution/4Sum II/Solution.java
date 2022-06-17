class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result=0;
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
          HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                
                    int sum=nums1[i]+nums2[j];
                    if(!h1.containsKey(sum))
                    {
                        h1.put(sum,1);
                    }
                    else
                    {
                        h1.put(sum,h1.get(sum)+1);
                    }
                
            }
        }
        
        for(int i=0;i<nums3.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                int sum=nums3[i]+nums4[j];
                if(!h2.containsKey(sum))
                    {
                        h2.put(sum,1);
                    }
                    else
                    {
                        h2.put(sum,h2.get(sum)+1);
                    }
            }
        }
        for(Map.Entry<Integer,Integer> entry1:h1.entrySet())
        {
            int key2=entry1.getKey();
            for(Map.Entry<Integer,Integer> entry2:h2.entrySet())
            {
                int key1=entry2.getKey();
                if(key1+key2==0)
                {
                    result+=entry1.getValue()*entry2.getValue();
                }
            }
        }
        
        return result;
    }
}
