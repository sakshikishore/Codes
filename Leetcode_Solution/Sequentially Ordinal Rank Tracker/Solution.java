class SORTracker {
    HashMap<Integer,ArrayList<String>> h;
    HashSet<Integer> hSet=new HashSet<Integer>();
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
    int i=0;
    public SORTracker() {
        h=new HashMap<Integer,ArrayList<String>>();
    }
    
    public void add(String name, int score) {
        if(!hSet.contains(score))
        {
            hSet.add(score);
            pq.add(score);
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
        ArrayList<Integer> h2=new ArrayList<Integer>();
       String res="";
       int count=0;
           while(pq.size()!=0)
           {
               int x=pq.poll();
               h2.add(x);
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
        for(int i=0;i<h2.size();i++)
        {
            pq.add(h2.get(i));
        }
       
        
        return res;
        
    }
}
