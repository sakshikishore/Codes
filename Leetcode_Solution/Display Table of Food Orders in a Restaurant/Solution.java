class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> list=new ArrayList();
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        ArrayList<String> l=new ArrayList<String>();
        ArrayList<String> table=new ArrayList<String>();
         ArrayList<Integer> t=new ArrayList<Integer>();
        for(int i=0;i<orders.size();i++)
        {
            if(!l.contains(orders.get(i).get(2)))
               {
                   l.add(orders.get(i).get(2));
               }
            if(!t.contains(Integer.parseInt(orders.get(i).get(1))))
            {
                t.add(Integer.parseInt(orders.get(i).get(1)));
            }
           String p = orders.get(i).get(1)+" "+orders.get(i).get(2);
            if(!h.containsKey(p))
            {
                h.put(p,1);
            }
            else
            {
                h.put(p,h.get(p)+1);
            }
        }
        Collections.sort(l);
        Collections.sort(t);
        for(int i=0;i<t.size();i++)
        {
            table.add(Integer.toString(t.get(i)));
        }
        l.add(0,"Table");
        list.add(l);
        for(int i=0;i<table.size();i++)
        {
            ArrayList<String> p=new ArrayList<String>();
            p.add(table.get(i));
            for(int j=1;j<l.size();j++)
            {
                String ptr=table.get(i)+" "+l.get(j);
                if(h.containsKey(ptr))
                {
                    p.add(Integer.toString(h.get(ptr)));
                }
                else
                {
                    p.add("0");
                }
            }
            list.add(p);
        }
        
        return list;
    }
}
