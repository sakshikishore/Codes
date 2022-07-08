class FindSumPairs {
   HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
   HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> h3=new HashMap<Integer,Integer>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        
        for(int i=0;i<nums1.length;i++)
        {
            if(!h1.containsKey(nums1[i]))
            {
                h1.put(nums1[i],1);
            }
            else
            {
                h1.put(nums1[i],h1.get(nums1[i])+1);
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            h3.put(i,nums2[i]);
            if(!h2.containsKey(nums2[i]))
            {
                h2.put(nums2[i],1);
            }
            else
            {
                h2.put(nums2[i],h2.get(nums2[i])+1);
            }
        }
    }
    
    public void add(int index, int val) {
        int x=h3.get(index);
        if(!h2.containsKey(val+x))
        {
            h2.put(val+x,1);
        }
        else
        {
            h2.put(val+x,h2.get(val+x)+1);
        }
        if(h2.get(x)==1)
        {
            h2.remove(x);
        }
        else
        {
          h2.put(x,h2.get(x)-1);
        }
        h3.put(index,val+x);
    }
    
    public int count(int tot) {
      int count=0;
           for(Map.Entry<Integer,Integer> entry:h1.entrySet())
           {
               int key=entry.getKey();
               int x=tot-key;
               if(h2.containsKey(x))
               {
                   count=count+(entry.getValue()*h2.get(x));
               }
           }
        
        return count;
       
    }
}
