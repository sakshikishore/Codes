class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            if(!hset.contains(nums1[i][0]))
            {
               pq.add(nums1[i][0]);
               hset.add(nums1[i][0]);
            }
           
                    h.put(nums1[i][0],nums1[i][1]);
        }
         for(int i=0;i<nums2.length;i++)
        {
            if(!hset.contains(nums2[i][0]))
            {
               pq.add(nums2[i][0]);
               hset.add(nums2[i][0]);
            }
              if(!h.containsKey(nums2[i][0]))
                {
                    h.put(nums2[i][0],nums2[i][1]);
                }
                else
                {
                    
                    h.put(nums2[i][0],h.get(nums2[i][0])+nums2[i][1]);
                }
        }
        int result[][]=new int[pq.size()][2];
        int k=0;
        while(pq.size()>0)
        {
            int n=pq.poll();
            result[k][0]=n;
            result[k][1]=h.get(n);
            k++;
        }
        
        return result;
        
    }
}
