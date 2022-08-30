class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxTime =-1;
        HashMap<String,Integer> h1=new HashMap<String,Integer>();
        HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<times.length;i++)
        {
            String str=Integer.toString(times[i][0])+" "+Integer.toString(times[i][1]);
            h1.put(str,times[i][2]);
            if(!h2.containsKey(times[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(times[i][1]);
                h2.put(times[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h2.get(times[i][0]);
                l.add(times[i][1]);
                h2.put(times[i][0],l);
            }
        }
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(k,0);
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(k);
        while(q.size()>0)
        {
           int x=q.poll();
           int t1=map.get(x);
           if(h2.containsKey(x))
           {
               ArrayList<Integer> l=h2.get(x);
               for(int j=0;j<l.size();j++)
               {
                   int y=l.get(j);
                   if(!map.containsKey(y))
                   {
                      String str=Integer.toString(x)+" "+Integer.toString(y);
                      int t2=h1.get(str);
                      map.put(y,t1+t2);
                      q.add(y);
                   }
                   else
                   {
                       int t3=map.get(y);
                      String str=Integer.toString(x)+" "+Integer.toString(y);
                      int t2=h1.get(str);
                      if(t3>(t2+t1))
                      {
                             map.put(y,t1+t2);
                             q.add(y);
                      }
                      
                   }
               }
           }
            
        }
        if(map.size()<n)
        {
            return -1;
        }
        else
        {
            for(Map.Entry<Integer,Integer> entry: map.entrySet())
            {
                int val=entry.getValue();
                if(val>maxTime)
                {
                    maxTime=val;
                }
            }
        }
        return maxTime;
    }
}
