class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       ArrayList<Integer> res=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        TreeSet<Integer> t=new TreeSet<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            int p=Math.abs(arr[i]-x);
            if(!h.containsKey(p))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(arr[i]);
                h.put(p,l);
            }
            else
            {
                ArrayList<Integer> l=h.get(p);
                l.add(arr[i]);
                h.put(p,l);
            }
            t.add(p);
        }
        int count=0;
        Iterator<Integer> itr=t.iterator();
        while(itr.hasNext())
        {
            int p=itr.next();
            ArrayList<Integer> l=h.get(p);
            for(int i=0;i<l.size();i++)
            {
                res.add(l.get(i));
                count++;
                if(count==k)
                {
                    break;
                }
            }
            if(count==k)
            {
                break;
            }
        }
        Collections.sort(res);
        
        return res;
    }
}
