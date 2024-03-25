class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int result[]=new int[people.length];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<flowers.length;i++)
        {
            if(!h.containsKey(flowers[i][0]))
            {
                pq.add(flowers[i][0]);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(flowers[i][1]);
                h.put(flowers[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(flowers[i][0]);
                l.add(flowers[i][1]);
                h.put(flowers[i][0],l);
            }
        }
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> p=new PriorityQueue<Integer>();
        for(int i=0;i<people.length;i++)
        {
            if(!map.containsKey(people[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                p.add(people[i]);
                map.put(people[i],l);
            }
            else
            {
                ArrayList<Integer> l=map.get(people[i]);
                l.add(i);
                map.put(people[i],l);
            }
        }
        while(p.size()>0)
        {
          int x=p.poll();
          while(pq.size()>0 && pq.peek()<=x)
          {
            int y=pq.poll();
            ArrayList<Integer> al=h.get(y);
            for(int i=0;i<al.size();i++)
            {
               int low=0,high=list.size()-1,index=0;
               while(low<=high)
               {
                 int mid=(low+high)/2;
                 if(list.get(mid)>al.get(i))
                 {
                    index=mid;
                    high=mid-1;
                 }
                 else
                 {
                    index=mid+1;
                    low=mid+1;
                 }
               }
               list.add(index,al.get(i));
            }
          }
          ArrayList<Integer> l=map.get(x);
          if(list.size()!=0)
          {
            int low=0,high=list.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>=x)
                {
                    index=mid;
                    high=mid-1;
                }
                else
                {
                    index=mid+1;
                    low=mid+1;
                }
            }
            int val=list.size()-index;
            for(int j=0;j<l.size();j++)
            {
                result[l.get(j)]=val;
            }
          }
        }

        return result;
    }
}
