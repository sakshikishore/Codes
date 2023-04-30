class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            l.add(nums1[i]);
            m.add(nums2[i]);
        }
        Collections.sort(l);
        Collections.sort(m);
        int i=0,j=l.size()-1;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
       for(int k=m.size()-1;k>=0;k--)
       {
           if(m.get(k)<l.get(j))
           {
              if(!h.containsKey(m.get(k)))
              {
                  ArrayList<Integer> al=new ArrayList<Integer>();
                  al.add(l.get(j));
                  h.put(m.get(k),al);
                  j--;
              }
              else
              {
                  ArrayList<Integer> al=h.get(m.get(k));
                  al.add(l.get(j));
                  h.put(m.get(k),al);
                  j--;
              }
           }
           else
           {
               if(!h.containsKey(m.get(k)))
                {
                    ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(l.get(i));
                    h.put(m.get(k),al);
                    i++;
                }
              else
              {
                  ArrayList<Integer> al=h.get(m.get(k));
                  al.add(l.get(i));
                  h.put(m.get(k),al);
                  i++;
              }
           }
       }

       for(i=0;i<nums2.length;i++)
       {
           ArrayList<Integer> list=h.get(nums2[i]);
           nums1[i]=list.get(0);
           list.remove(0);
           if(list.size()==0)
           {
               h.remove(nums2[i]);
           }
           else
           {
               h.put(nums2[i],list);
           }
       }

       return nums1;
    }
}
