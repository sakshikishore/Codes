class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>(); 
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>(); 
    
        for(int i=0;i<prerequisites.length;i++)
        {
            if(!h.containsKey(prerequisites[i][0]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(prerequisites[i][1]);
                h.put(prerequisites[i][0],list);
            }
            else
            {
                ArrayList<Integer> list=h.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
                h.put(prerequisites[i][0],list);
            }

            if(!map.containsKey(prerequisites[i][1]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],list);
            }
            else
            {
                ArrayList<Integer> list=map.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],list);
            }

        }
       Queue<Integer> q=new LinkedList<Integer>();
        HashMap<Integer,HashSet<Integer>> dependentCourse=new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<numCourses;i++)
        {
            if(!h.containsKey(i))
            {
                q.add(i);
                HashSet<Integer> hset=new HashSet<Integer>();
                dependentCourse.put(i,hset);
            }
        }
        while(q.size()>0)
        {
            int x=q.poll();
            if(map.containsKey(x))
            {
                ArrayList<Integer> l=map.get(x);
                map.remove(x);
                for(int j=0;j<l.size();j++)
                {
                       ArrayList<Integer> al=h.get(l.get(j));
                       int index=al.indexOf(x);
                       al.remove(index);
                       if(al.size()==0)
                       {
                          h.remove(l.get(j));
                          q.add(l.get(j));
                       }
                       else
                       {
                          h.put(l.get(j),al);
                       }
                          HashSet<Integer> hset=dependentCourse.get(x);
                          HashSet<Integer> hset1=new HashSet<Integer>();
                          if(dependentCourse.containsKey(l.get(j)))
                          {
                                hset1=dependentCourse.get(l.get(j));
                          }
                          Iterator<Integer> itr=hset.iterator();
                          while(itr.hasNext())
                          {
                            hset1.add(itr.next());
                          }
                          hset1.add(x);
                          dependentCourse.put(l.get(j),hset1);
                }
            }

        }
        
       ArrayList< Boolean> result=new ArrayList<Boolean>();
        for(int i=0;i<queries.length;i++)
        {
            int x=queries[i][0];
            HashSet<Integer> hset=dependentCourse.get(x);
            if(hset.contains(queries[i][1]))
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }

        return result;
    }
}
