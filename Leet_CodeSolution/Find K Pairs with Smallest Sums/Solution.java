class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
       TreeMap<Integer,List<List<Integer>>> t=new TreeMap<Integer,List<List<Integer>>>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
               
                 if(pq.size()<k)
                 {
                     pq.add(nums1[i]+nums2[j]);
                     if(!t.containsKey(nums1[i]+nums2[j]))
                     {
                         List<List<Integer>> list=new ArrayList();
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(nums1[i]);
                        l.add(nums2[j]);
                        list.add(l);
                        t.put(nums1[i]+nums2[j],list);
                     }
                     else
                     {
                        List<List<Integer>> list=t.get(nums1[i]+nums2[j]);
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(nums1[i]);
                        l.add(nums2[j]);
                        list.add(l);
                        t.put(nums1[i]+nums2[j],list);
                     }
                 }
                 else if(nums1[i]+nums2[j]<pq.peek())
                 {
                    int x=pq.poll();
                    t.get(x).remove(0);
                    if(t.get(x).size()==0)
                    {
                        t.remove(x);
                    }
                     pq.add(nums1[i]+nums2[j]);
                     if(!t.containsKey(nums1[i]+nums2[j]))
                     {
                         List<List<Integer>> list=new ArrayList();
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(nums1[i]);
                        l.add(nums2[j]);
                        list.add(l);
                        t.put(nums1[i]+nums2[j],list);
                     }
                     else
                     {
                        List<List<Integer>> list=t.get(nums1[i]+nums2[j]);
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(nums1[i]);
                        l.add(nums2[j]);
                        list.add(l);
                        t.put(nums1[i]+nums2[j],list);
                     }
                 }
                 else
                 {
                     break;
                 }
            }
        }
        List<List<Integer>> result=new ArrayList();
        for(Map.Entry<Integer,List<List<Integer>>> entry:t.entrySet())
        {
            List<List<Integer>> val=entry.getValue();
            for(int i=0;i<val.size();i++)
            {
                result.add(val.get(i));
            }
        }

        return result;
    }
}
