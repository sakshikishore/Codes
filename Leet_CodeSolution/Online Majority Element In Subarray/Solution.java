class MajorityChecker {
   HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
   HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
   int max=1;
   ArrayList<Integer> al=new ArrayList<Integer>();
    public MajorityChecker(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            if(h.containsKey(arr[i]))
            {
                ArrayList<Integer> l=h.get(arr[i]);
                l.add(i);
                h.put(arr[i],l);
            }
            else
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(arr[i],l);
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
        {
            int key=entry.getKey();
            int val=entry.getValue().size();
            if(map.containsKey(val))
            {
                ArrayList<Integer> l=map.get(val);
                l.add(key);
                map.put(val,l);
            }
            else
            {
                al.add(val);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(key);
                map.put(val,l);
            }
            
        }
        Collections.sort(al);
        max=al.get(al.size()-1);
    }
    
    public int query(int left, int right, int threshold) {
        if(max<threshold)
        {
            return -1;
        }
        for(int i=al.size()-1;i>=0;i--)
        {
            int p=al.get(i);
            if(p>=threshold)
            {
                ArrayList<Integer> l=map.get(p);
                for(int j=0;j<l.size();j++)
                {
                    ArrayList<Integer> list=h.get(l.get(j));
                    int count=0;
                    for(int x=0;x<list.size();x++)
                    {
                        if(list.get(x)>right)
                        {
                            break;
                        }
                        else
                        {
                            if(list.get(x)>=left)
                            {
                                count++;
                            }
                        }
                    }
                    if(count>=threshold)
                    {
                        return l.get(j);
                    }
                }
            }
        }

        return -1;


    }
}
