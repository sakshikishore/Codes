class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer,ArrayList<Integer>> h=new  HashMap<Integer,ArrayList<Integer>>();
        HashSet<Integer> h1=new HashSet<Integer>();
        int ans=1;
        for(int i=0;i<restricted.length;i++)
        {
          h1.add(restricted[i]);
        }
        for(int i=0;i<edges.length;i++)
        {
            if(h1.contains(edges[i][0]) || h1.contains(edges[i][1]))
            {
                continue;
            }
            if(!h.containsKey(edges[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][1]);
                h.put(edges[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][0]);
                l.add(edges[i][1]);
                h.put(edges[i][0],l);
            }
            
            if(!h.containsKey(edges[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][1]);
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
            
            
        }
        if(h.containsKey(0))
        {
            int flag=0;
            ArrayList<Integer> visited=new ArrayList<Integer>();
            HashSet<Integer> h2=new HashSet<Integer>();
            visited.add(0);
            h2.add(0);
            int j=0;
            while(flag!=1)
            {
               int x=visited.get(j);
               ArrayList<Integer> y=h.get(x);
               for(int i=0;i<y.size();i++)
               {
                   if(!h2.contains(y.get(i)))
                   {
                       visited.add(y.get(i));
                       h2.add(y.get(i));
                   }
               }
                
              h.remove(x);
              j++;
              if(visited.size()==j)
              {
                  break;
              }
            }
            ans=visited.size();
        }
        
        
     return ans;
         
        
        
    }
}
