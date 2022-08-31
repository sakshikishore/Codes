class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result=new ArrayList();
       HashMap<String,ArrayList<Integer>> map=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(!map.containsKey(accounts.get(i).get(j)))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    map.put(accounts.get(i).get(j),l);
                }
                else
                {
                    ArrayList<Integer> l=map.get(accounts.get(i).get(j));
                    l.add(i);
                    map.put(accounts.get(i).get(j),l);
                }
            }
        }
        
       HashSet<Integer> h=new HashSet<Integer>();
       for(int i=0;i<accounts.size();i++)
       {
           if(!h.contains(i))
           {
               String name=accounts.get(i).get(0);
               TreeSet<String> set=new TreeSet<String>();
               h.add(i);
               Queue<String> q=new LinkedList<String>();
               for(int j=1;j<accounts.get(i).size();j++)
               {
                   q.add(accounts.get(i).get(j));
                   set.add(accounts.get(i).get(j));
               }
               while(q.size()>0)
               {
                   String mail=q.poll();
                   ArrayList<Integer> l=map.get(mail);
                   for(int j=0;j<l.size();j++)
                   {
                       int index=l.get(j);
                       if(!h.contains(index))
                       {
                           h.add(index);
                           for(int k=1;k<accounts.get(index).size();k++)
                           {
                               String s=accounts.get(index).get(k);
                               if(!set.contains(s))
                               {
                                   set.add(s);
                                   q.add(s);
                               }
                           }
                       }
                   }
               }
               ArrayList<String> al=new ArrayList<String>();
               al.add(name);
               Iterator<String> itr=set.iterator();
               while(itr.hasNext())
               {
                   al.add(itr.next());
               }
               
               result.add(al);
           }
       }
        
        return result;
    }
}
