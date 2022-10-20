class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeSet<String> t=new TreeSet<String>();
       HashMap<Integer,ArrayList<String>> h=new HashMap<Integer,ArrayList<String>>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<keyTime.length;i++)
        {
            int minutes=Integer.parseInt(keyTime[i].substring(0,2))*60+Integer.parseInt(keyTime[i].substring(3));
            if(!h.containsKey(minutes))
            {
                al.add(minutes);
                ArrayList<String> l=new ArrayList<String>();
                l.add(keyName[i]);
                h.put(minutes,l);
            }
            else
            {
                ArrayList<String> l=h.get(minutes);
                l.add(keyName[i]);
                h.put(minutes,l);
            }
        }
        
        Collections.sort(al);
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        ArrayList<String> l=h.get(al.get(0));
        for(int i=0;i<l.size();i++)
        {
            map.put(l.get(i),1);
        }
        int j=0;
        for(int i=1;i<al.size();i++)
        {
            if(al.get(i)-al.get(j)<=60)
            {
                   l=h.get(al.get(i));
                    for(int k=0;k<l.size();k++)
                    {
                        if(!map.containsKey(l.get(k)))
                        {
                          map.put(l.get(k),1);
                        }
                        else
                        {
                            map.put(l.get(k),map.get(l.get(k))+1);
                            if(map.get(l.get(k))>=3)
                            {
                                t.add(l.get(k));
                            }
                        }
                    }
            }
            else
            {
                l=h.get(al.get(j));
                for(int k=0;k<l.size();k++)
                {
                   if(map.get(l.get(k))==1)
                   {
                       map.remove(l.get(k));
                   }
                    else
                    {
                        map.put(l.get(k),map.get(l.get(k))-1);
                    }
                }
                j++;
                i--;
            }
        }
       ArrayList<String> result=new ArrayList<String>();
       Iterator<String> itr=t.iterator();
        while(itr.hasNext())
        {
            result.add(itr.next());
        }
        
        return result;
    }
}
