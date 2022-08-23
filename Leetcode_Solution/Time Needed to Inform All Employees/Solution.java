class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
        {
            return 0;
        }
        else
        {
            int totalTime=0;
            HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
            for(int i=0;i<manager.length;i++)
            {
               if(manager[i]!=-1)
               {
                   if(!h.containsKey(manager[i]))
                   {
                       ArrayList<Integer> l=new ArrayList<Integer>();
                       l.add(i);
                       h.put(manager[i],l);
                   }
                   else
                   {
                       ArrayList<Integer> l=h.get(manager[i]);
                       l.add(i);
                       h.put(manager[i],l);
                   }
               }
            }
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(headID);
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            map.put(headID,0);
            while(q.size()>0)
            {
                    int temp=q.poll();
                    if(h.containsKey(temp))
                    {
                        ArrayList<Integer> l=h.get(temp);
                        for(int i=0;i<l.size();i++)
                        {
                            map.put(l.get(i),map.get(temp)+informTime[temp]);
                            q.add(l.get(i));
                        }
                    }
                    else
                    {
                         if(map.get(temp)>totalTime)
                         {
                             totalTime=map.get(temp);
                         }
                    }
                
                
            }
            
            return totalTime;
        }
    }
}
