class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int result[][]=new int[people.length][2];
      ArrayList<Integer> l=new ArrayList<Integer>();
      HashMap<Integer,PriorityQueue<Integer>> h=new HashMap<Integer,PriorityQueue<Integer>>();
      HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<Integer,PriorityQueue<Integer>>();
      PriorityQueue<Integer> q=new PriorityQueue<Integer>();
      for(int i=0;i<people.length;i++)
      {
          if(!h.containsKey(people[i][1]))
          {
              q.add(people[i][1]);
              PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
              pq.add(people[i][0]);
              h.put(people[i][1],pq);
          }
          else
          {
              PriorityQueue<Integer> pq=h.get(people[i][1]);
              pq.add(people[i][0]);
              h.put(people[i][1],pq);
          }
            if(!map.containsKey(people[i][0]))
          {
              PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
              pq.add(people[i][1]);
              map.put(people[i][0],pq);
          }
          else
          {
              PriorityQueue<Integer> pq=map.get(people[i][0]);
              pq.add(people[i][1]);
              map.put(people[i][0],pq);
          }
      }
      while(q.size()>0)
      {
          int x=q.poll();
          PriorityQueue<Integer> pq=h.get(x);
          while(pq.size()>0)
          {
                 if(x==0)
                 {
                     
                     l.add(pq.poll());
                 }
                 else
                 {
                     int val=pq.poll();
                     int i=0,j=0;
                     while(j<l.size() && i!=x)
                     {
                         if(l.get(j)>=val)
                         {
                             i++;
                         }
                         j++;
                     }
                     while(j<l.size() && l.get(j)<val)
                     {
                         j++;
                     }
                    l.add(j,val);
                 }
          }
      }
      for(int i=0;i<l.size();i++)
      {
         result[i][0]=l.get(i);
         result[i][1]=map.get(l.get(i)).poll();
      }
      
      return result;
    }
}
