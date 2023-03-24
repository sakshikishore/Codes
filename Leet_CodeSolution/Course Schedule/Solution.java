class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      if(numCourses==1 || prerequisites.length==1)
      {
          return true;
      }
       Queue<Integer> q=new LinkedList<Integer>();
       HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
       HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
       HashSet<Integer> hset=new HashSet<Integer>();
       for(int i=0;i<prerequisites.length;i++)
       {
           hset.add(prerequisites[i][0]);
            if(!h1.containsKey(prerequisites[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(prerequisites[i][1]);
                h1.put(prerequisites[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h1.get(prerequisites[i][0]);
                l.add(prerequisites[i][1]);
                h1.put(prerequisites[i][0],l);
            }
            if(!h2.containsKey(prerequisites[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(prerequisites[i][0]);
                h2.put(prerequisites[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h2.get(prerequisites[i][1]);
                l.add(prerequisites[i][0]);
                h2.put(prerequisites[i][1],l);
            }
       }
       for(int i=0;i<numCourses;i++)
       {
           if(!hset.contains(i))
           {
              q.add(i);
           }
       }
       if(q.size()==0)
       {
           return false;
       }
       while(q.size()>0)
       {
           int r=q.poll();
           if(h2.containsKey(r))
           {
               ArrayList<Integer> p=h2.get(r);
               h2.remove(r);
               for(int j=0;j<p.size();j++)
               {
                  ArrayList<Integer> k=h1.get(p.get(j));
                  k.remove(new Integer(r));
                  if(k.size()==0)
                  {
                      q.add(p.get(j));
                      h1.remove(p.get(j));
                  }
                  else
                  {
                      h1.put(p.get(j),k);
                  }
               }
           }
       }

       if(h1.size()==0)
       {
           return true;
       }
       return false;
    }
}
