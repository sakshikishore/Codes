class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int result=0,min=Integer.MAX_VALUE;
      HashMap<String,Integer> h1=new HashMap<String,Integer>();
      HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
      for(int i=0;i<edges.length;i++)
      {
          String str1=Integer.toString(edges[i][0])+" "+Integer.toString(edges[i][1]);
          h1.put(str1,edges[i][2]);
          String str2=Integer.toString(edges[i][1])+" "+Integer.toString(edges[i][0]);
          h1.put(str2,edges[i][2]);
          if(!h2.containsKey(edges[i][0]))
          {
              ArrayList<Integer> l=new ArrayList<Integer>();
              l.add(edges[i][1]);
              h2.put(edges[i][0],l);
          }
          else
          {
              ArrayList<Integer> l=h2.get(edges[i][0]);
              l.add(edges[i][1]);
              h2.put(edges[i][0],l);
          }
          if(!h2.containsKey(edges[i][1]))
          {
              ArrayList<Integer> l=new ArrayList<Integer>();
              l.add(edges[i][0]);
              h2.put(edges[i][1],l);
          }
          else
          {
              ArrayList<Integer> l=h2.get(edges[i][1]);
              l.add(edges[i][0]);
              h2.put(edges[i][1],l);
          }
          
      }
         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Integer> h3=new HashMap<Integer,Integer>();
            h3.put(i,0);
            HashMap<String,Integer> h=new HashMap<String,Integer>();
            String s1=Integer.toString(i);
            h.put(s1,0);
            Queue<String> q=new LinkedList<String>();
            q.add(s1);
            HashSet<Integer> element=new HashSet<Integer>();
            while(q.size()>0)
            {
                String s=q.poll();
                //System.out.println(s+" "+h.get(s));
                String str[]=s.split(" ");
                HashSet<Integer> hset=new HashSet<Integer>();
                for(int j=0;j<str.length;j++)
                {
                  hset.add(Integer.parseInt(str[j]));
                }
                String p=str[str.length-1];
                int x=Integer.parseInt(p);
                element.add(x);
                int t1=h.get(s);
                if(h2.containsKey(x))
                {
                ArrayList<Integer> l=h2.get(x);
                for(int j=0;j<l.size();j++)
                {
                      if(!hset.contains(l.get(j)))
                       {
                           String k=p+" "+Integer.toString(l.get(j));
                           int t2=h1.get(k);
                           if((t1+t2)<=distanceThreshold)
                           {
                               if(h3.containsKey(l.get(j)))
                               {
                                   if(h3.get(l.get(j))>(t1+t2))
                                   {
                                       h3.put(l.get(j),t1+t2);
                                       q.add(s+" "+Integer.toString(l.get(j)));
                                       h.put(s+" "+Integer.toString(l.get(j)),(t1+t2));
                                   }
                               }
                               else
                               {
                                   h3.put(l.get(j),t1+t2);
                                   q.add(s+" "+Integer.toString(l.get(j)));
                                   h.put(s+" "+Integer.toString(l.get(j)),(t1+t2));
                               }
                           }
                           
                       }
                }
            }
            }
            map.put(i,element.size());
            if(element.size()<=min)
            {
                min=element.size();
                result=i;
            }
        }
        
        
        return result;
    }
}
