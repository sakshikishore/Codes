class SORTracker {
    HashMap<Integer,ArrayList<String>> h;
    HashSet<Integer> hSet=new HashSet<Integer>();
    ArrayList<Integer> l=new ArrayList<Integer>();
    int i=0;
    public SORTracker() {
        h=new HashMap<Integer,ArrayList<String>>();
    }
    
    public void add(String name, int score) {
        if(!hSet.contains(score))
        {
            hSet.add(score);
            l.add(score);
        }
        if(!h.containsKey(score))
        {
            ArrayList<String> t=new ArrayList<String>();
            t.add(name);
            h.put(score,t);
        }
        else
        {
            ArrayList<String> t=h.get(score);
            t.add(name);
            h.put(score,t);
        }
    }
    
    public String get() {
       i++;
       String res="";
       int count=0;
       Collections.sort(l);
       
           for(int j=l.size()-1;j>=0;j--)
           {
               int x=l.get(j);
               if(h.get(x).size()+count<i)
               {
                   count=count+h.get(x).size();
               }
               else
               {
                    int p=i-count;
                    ArrayList<String> al=h.get(x);
                    Collections.sort(al);
                    res=al.get(p-1);
                    count=i;
                    break;
               }
           }
       
        
        return res;
        
    }
}
