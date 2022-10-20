class LRUCache {
    int totalCapacity=0;
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    ArrayList<Integer> l=new ArrayList<Integer>();
    public LRUCache(int capacity) {
        totalCapacity=capacity;
    }
    
    public int get(int key) {
     
        if(h.containsKey(key))
        {
            int x=l.indexOf(key);
            if(x!=-1)
            {
              l.remove(x);  
            }
            l.add(key);
            return h.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(h.containsKey(key))
        {
            h.put(key,value);
             int index=-1;
             for(int j=0;j<l.size();j++)
               {
                   if(l.get(j)==key)
                   {
                       index=j;
                       break;
                   }
               }
                if(index!=-1)
                {
                    l.remove(index);
                }
             l.add(key);
        }
        else
        {
            if(h.size()<totalCapacity)
            {
                h.put(key,value);
                int index=-1;
               for(int j=0;j<l.size();j++)
               {
                   if(l.get(j)==key)
                   {
                       index=j;
                       break;
                   }
               }
                if(index!=-1)
                {
                    l.remove(index);
                }
                l.add(key);
            }
            else
            {
                h.remove(l.get(0));
                l.remove(0);
                h.put(key,value);
                int index=-1;
                  for(int j=0;j<l.size();j++)
                   {
                       if(l.get(j)==key)
                       {
                           index=j;
                           break;
                       }
                   }
                if(index!=-1)
                {
                    l.remove(index);
                }
               l.add(key);

            }
        }
    }
}
