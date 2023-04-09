class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      if(numCourses==1 || prerequisites.length==0)
      {
          int result[]=new int[numCourses];
          for(int i=0;i<result.length;i++)
          {
              result[i]=i;
          }
          return result;
      }
       Stack<Integer> stck=new Stack<Integer>();
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
              stck.push(i);
           }
       }
       if(stck.size()==0)
       {
           int result[]=new int[0];
           return result;
       }
       ArrayList<Integer> l=new ArrayList<Integer>();
       int i=0;
       int result[]=new int[numCourses];
       while(stck.size()>0)
       {
           int r=stck.pop();
           result[i]=r;
           i++;
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
                      stck.push(p.get(j));
                      h1.remove(p.get(j));
                  }
                  else
                  {
                      h1.put(p.get(j),k);
                  }
               }
           }
       }

       if(h1.size()!=0)
       {
           result=new int[0];
           return result;
       }
       return result;
    }
}
