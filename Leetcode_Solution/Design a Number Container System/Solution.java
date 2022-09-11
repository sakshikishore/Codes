class NumberContainers {
   TreeSet<Integer> t=new TreeSet<Integer>();
    HashMap<Integer,Integer> map;
    public NumberContainers() {
        map=new HashMap<Integer,Integer>();
    }
    
    public void change(int index, int number) {
        map.put(index,number);
        t.add(index);
    }
    
    public int find(int number) {
       Iterator<Integer> itr=t.iterator();
        while(itr.hasNext())
        {
            int index=itr.next();
            if(map.get(index)==number)
            {
                return index;
            }
        }
        
        return -1;
    }
}
