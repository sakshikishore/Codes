class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
         HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<graph.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<graph[i].length;j++)
            {
                if(!h2.containsKey(graph[i][j]))
                {
                  ArrayList<Integer> al=new ArrayList<Integer>(); 
                    al.add(i);
                    h2.put(graph[i][j],al);
                }
                else
                {
                   ArrayList<Integer> al=h2.get(graph[i][j]);
                    al.add(i);
                    h2.put(graph[i][j],al);
                }
                l.add(graph[i][j]);
                h1.put(i,l);
            }

        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<graph.length;i++)
        {
              if(!h1.containsKey(i))
              {
                  q.add(i);
              }
        }
        while(q.size()>0)
        {
            int x=q.poll();
             result.add(x);
            if(h2.containsKey(x))
            {
                ArrayList<Integer> al=h2.get(x);
                for(int i=0;i<al.size();i++)
                {
                      ArrayList<Integer> l=h1.get(al.get(i));
                      if(l.size()==1)
                      {
                          h1.remove(al.get(i));
                          q.add(al.get(i));
                      }
                      int low=0,high=l.size()-1;
                      while(low<=high)
                      {
                          int mid=(low+high)/2;
                          if(l.get(mid)==x)
                          {
                              l.remove(mid);
                              break;
                          }
                          else if(l.get(mid)>x)
                          {
                              high=mid-1;
                          }
                          else
                          {
                              low=mid+1;
                          }
                      }

                      h1.put(al.get(i),l);
                }
                h2.remove(x);
            }
        }

        Collections.sort(result);

        return result;

    }
}
