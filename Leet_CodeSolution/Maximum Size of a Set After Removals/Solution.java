class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        int count1=0,count2=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(!h1.containsKey(nums1[i]))
            {
                h1.put(nums1[i],1);
            }
            else
            {
                   if(count1<nums1.length/2)
                   {
                     count1++;
                   }
                   else
                   {
                        h1.put(nums1[i],h1.get(nums1[i])+1);
                   }
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(!h2.containsKey(nums2[i]))
            {
                h2.put(nums2[i],1);
            }
            else
            {
                   if(count2<nums2.length/2)
                   {
                     count2++;
                   }
                   else
                   {
                        h2.put(nums2[i],h2.get(nums2[i])+1);
                   }
            }
        }
        if(count1==nums1.length/2 && count2==nums2.length/2)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(Map.Entry<Integer,Integer> entry:h1.entrySet())
            {
                hset.add(entry.getKey());
            }
            for(Map.Entry<Integer,Integer> entry:h2.entrySet())
            {
                hset.add(entry.getKey());
            }

            return hset.size();
        }
        else if(count1==nums1.length/2)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(Map.Entry<Integer,Integer> entry:h1.entrySet())
            {
                hset.add(entry.getKey());
            }
            for(Map.Entry<Integer,Integer> entry:h2.entrySet())
            {
               int p=entry.getKey();
               if(hset.contains(p))
               {
                    if(count2<nums2.length/2)
                    {
                    count2++;
                    }
               }
               else
               {
                hset.add(p);
               }
            }
            
                return hset.size()-((nums2.length/2)-count2);

        }
        else if(count2==nums2.length/2)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(Map.Entry<Integer,Integer> entry:h2.entrySet())
            {
                hset.add(entry.getKey());
            }
            for(Map.Entry<Integer,Integer> entry:h1.entrySet())
            {
               int p=entry.getKey();
               if(hset.contains(p))
               {
                    if(count1<nums1.length/2)
                    {
                    count1++;
                    }
               }
               else
               {
                hset.add(p);
               }
            }
         
                return hset.size()-((nums1.length/2)-count1);

        }
        else
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(Map.Entry<Integer,Integer> entry:h1.entrySet())
            {
                int p=entry.getKey();
                if(h2.containsKey(p))
                {
                    if(count1<nums1.length/2)
                    {
                        count1++;
                    }
                    else
                    {
                        hset.add(p);
                    }
                }
                else
                {
                    hset.add(p);
                }
            }

            for(Map.Entry<Integer,Integer> entry:h2.entrySet())
            {
                int p=entry.getKey();
                if(hset.contains(p))
                {
                    if(count2<nums2.length/2)
                    {
                        count2++;
                    }
                    else
                    {
                        hset.add(p);
                    }
                }
                else
                {
                    hset.add(p);
                }
            }

            return hset.size()-((nums1.length/2)-count1)-((nums2.length/2)-count2);
        }
     
    }
}
