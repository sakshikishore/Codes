class LFUCache {
   HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
   HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
   TreeMap<Integer,ArrayList<Integer>> t=new TreeMap<Integer,ArrayList<Integer>>();
   int cap=0;
    public LFUCache(int capacity) {
        cap=capacity;
    }
    
    public int get(int key) {
        if(h.containsKey(key))
        {
            int x=map.get(key);
            map.put(key,x+1);
            ArrayList<Integer> l=t.get(x);
            l.remove(new Integer(key));
            if(l.size()==0)
            {
                t.remove(x);
            }
            else
            {
                 t.put(x,l);
            }
            if(!t.containsKey(x+1))
            {
                l=new ArrayList<Integer>();
                l.add(key);
                t.put(x+1,l);
            }
            else
            {
                 l=t.get(x+1);
                l.add(key);
                t.put(x+1,l); 
            }
            return h.get(key);
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(h.containsKey(key))
        {
            h.put(key,value);
            int x=map.get(key);
            ArrayList<Integer> l=t.get(x);
            l.remove(new Integer(key));
             if(l.size()==0)
            {
                t.remove(x);
            }
            else
            {
                 t.put(x,l);
            }
            map.put(key,x+1);
            if(!t.containsKey(x+1))
            {
                 l=new ArrayList<Integer>();
                l.add(key);
                t.put(x+1,l);
            }
            else
            {
                l=t.get(x+1);
                l.add(key);
                t.put(x+1,l); 
            }
        }
        else
        {
            if(h.size()<cap)
            {
            h.put(key,value);
            int x=0;
            map.put(key,x+1);
            if(!t.containsKey(x+1))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(key);
                t.put(x+1,l);
            }
            else
            {
                ArrayList<Integer> l=t.get(x+1);
                l.add(key);
                t.put(x+1,l); 
            }
            }
            else
            {
                int k=t.firstKey();
                ArrayList<Integer> l=t.get(k);
                int p=l.remove(0);
                h.remove(p);
                map.remove(p);
                h.put(key,value);
                 int x=0;
            map.put(key,x+1);
            if(!t.containsKey(x+1))
            {
                l=new ArrayList<Integer>();
                l.add(key);
                t.put(x+1,l);
            }
            else
            {
                 l=t.get(x+1);
                l.add(key);
                t.put(x+1,l); 
            }
            }
        }
    }
}
