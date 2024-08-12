class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int chairMap[]=new int[times.length];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        PriorityQueue<Integer> freeChair=new PriorityQueue<Integer>();
        freeChair.add(0);
        int max=1;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        TreeMap<Integer,Integer> t=new TreeMap<Integer,Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<times.length;i++)
        {
            t.put(times[i][0],times[i][1]);
            map.put(times[i][0],i);
        }
        for(Map.Entry<Integer,Integer> entry:t.entrySet())
        {
             int time=entry.getKey();
             int val=entry.getValue();
             while(pq.size()>0 && pq.peek()<=time)
             {
               
               int endTime=pq.poll();
               ArrayList<Integer> list=h.get(endTime);
               for(int i=0;i<list.size();i++)
               {
                 freeChair.add(chairMap[list.get(i)]);
               }
               h.remove(endTime);

             }
             if(!h.containsKey(val))
             {
                pq.add(val);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(map.get(time));
                h.put(val,l);
             }
             else
             {
                ArrayList<Integer> l=h.get(val);
                 l.add(map.get(time));
                 h.put(val,l);
             }
             if(map.get(time)==targetFriend)
             {
                
                return freeChair.poll();
             }
             chairMap[map.get(time)]=freeChair.poll();
            
             if(freeChair.size()==0)
             {
                freeChair.add(max);
                max=max+1;
             }
        }

      return 0;
    }
}
