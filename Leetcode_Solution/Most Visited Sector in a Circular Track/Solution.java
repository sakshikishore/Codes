class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=1;i<rounds.length;i++)
        {
              if(rounds[i-1]<=rounds[i])
              {
                   int p=rounds[i-1];
                  while(p<rounds[i])
                  {
                      if(!h.containsKey(p))
                      {
                          h.put(p,1);
                      }
                      else
                      {
                          h.put(p,h.get(p)+1);
                      }
                      p++;
                  }
                  
              }
            else
            {
                int p=rounds[i-1];
                while(p!=rounds[i])
                {
                     if(!h.containsKey(p))
                      {
                          h.put(p,1);
                      }
                      else
                      {
                          h.put(p,h.get(p)+1);
                      }
                    p++;
                    if(p>n)
                    {
                    p=p%n;
                    }
                }
                
            }
        }
        
                     if(!h.containsKey(rounds[rounds.length-1]))
                      {
                          h.put(rounds[rounds.length-1],1);
                      }
                      else
                      {
                          h.put(rounds[rounds.length-1],h.get(rounds[rounds.length-1])+1);
                      }
        
        int max=0;
        for(Map.Entry<Integer,Integer> m: h.entrySet())
        {
            if(m.getValue()>max)
            {
                l=new ArrayList<Integer>();
                max=m.getValue();
                l.add(m.getKey());
            }
            else if(m.getValue()==max)
            {
                l.add(m.getKey());
            }
        }
    Collections.sort(l);
        
        return l;
    }
}
