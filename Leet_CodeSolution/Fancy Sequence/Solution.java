class Fancy {
   HashMap<Integer,Long> h;
   HashMap<Integer,Integer> map;
   ArrayList<Integer> list=new ArrayList<Integer>(); // for add value=0, for multiply val=1
   ArrayList<Integer> l=new ArrayList<Integer>();
   int i=0;
   int flag=0;
   long prod=-1,sum=0;
    public Fancy() {
        h=new HashMap<Integer,Long>();
        map=new HashMap<Integer,Integer>(); 
    }
    
    public void append(int val) {
        if(prod!=-1)
        {
            list.add(1);
            l.add((int)prod);
            prod=-1;
        }
        if(sum!=0)
        {
            list.add(0);
            l.add((int)sum);
            sum=0;
        }
        long x=val;
        h.put(i,x);
        map.put(i,list.size());
        i++;
    }
    
    public void addAll(int inc) {
        if(prod!=-1)
        {
            list.add(1);
            l.add((int)prod);
            prod=-1;
        }
        sum=sum+inc;
    }
    
    public void multAll(int m) {
        if(sum!=0)
        {
            list.add(0);
            l.add((int)sum);
            sum=0;
        }
        if(prod==-1)
        {
           prod=1;
        }
        prod=(prod*m)%1000000007;
    }
    
    public int getIndex(int idx) {
        if(prod!=-1)
        {
            list.add(1);
            l.add((int)prod);
            prod=-1;
        }
        if(sum!=0)
        {
            list.add(0);
            l.add((int)sum);
            sum=0;
        }
        if(!h.containsKey(idx))
        {
            return -1;
        }
        long val=h.get(idx);
        for(int j=map.get(idx);j<list.size();j++)
        {
            if(list.get(j)==0)
            {
                val+=l.get(j);
                val=val%(1000000007);
            }
            else
            {
                val=val*(l.get(j));
                val=val%(1000000007);
            }
        }

        return (int)val;
    }
}
