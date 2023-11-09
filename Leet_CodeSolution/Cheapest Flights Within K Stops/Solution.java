class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<Integer,HashMap<Integer,Integer>>();
        int result=Integer.MAX_VALUE;
        for(int i=0;i<flights.length;i++)
        {
            if(!h.containsKey(flights[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(flights[i][1]);
                h.put(flights[i][0],l);
                HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
                hmap.put(flights[i][1],flights[i][2]);
                map.put(flights[i][0],hmap);
            }
            else
            {
                ArrayList<Integer> l=h.get(flights[i][0]);
                l.add(flights[i][1]);
                h.put(flights[i][0],l);
                HashMap<Integer,Integer> hmap=map.get(flights[i][0]);
                hmap.put(flights[i][1],flights[i][2]);
                map.put(flights[i][0],hmap);
            }
        }
        Queue<String> q=new LinkedList<String>();
        int flag=0;
        q.add(Integer.toString(src)+" "+Integer.toString(0)+" "+Integer.toString(0));
        HashMap<Integer,Integer> priceMap=new HashMap<Integer,Integer>();
        priceMap.put(src,0);
        while(q.size()>0)
        {
          String str[]=q.poll().split(" ");
          int city=Integer.parseInt(str[0]);
          int stop=Integer.parseInt(str[1]);
          int cost=Integer.parseInt(str[2]);
          if(city==dst)
          {
              flag=1;
              if(result>cost)
              {
                result=cost;
              }
          }
          else
          {
            if(h.containsKey(city))
            {
                ArrayList<Integer> al=h.get(city);
                for(int i=0;i<al.size();i++)
                {
                   int price=cost+map.get(city).get(al.get(i));
                   if(priceMap.containsKey(al.get(i)))
                   {
                        int x=priceMap.get(al.get(i));
                        if(x>price)
                        {
                            priceMap.put(al.get(i),price);
                            if(al.get(i)==dst)
                           {
                             q.add(Integer.toString(al.get(i))+" "+Integer.toString(stop)+" "+Integer.toString(price));
                           }
                           else if(stop+1<=k)
                           {
                                q.add(Integer.toString(al.get(i))+" "+Integer.toString(stop+1)+" "+Integer.toString(price));
                           }
                        }
                   }
                   else
                   {
                          priceMap.put(al.get(i),price);
                       if(al.get(i)==dst)
                           {
                             q.add(Integer.toString(al.get(i))+" "+Integer.toString(stop)+" "+Integer.toString(price));
                           }
                           else if(stop+1<=k)
                           {
                                q.add(Integer.toString(al.get(i))+" "+Integer.toString(stop+1)+" "+Integer.toString(price));
                           }
                   }
                }
            }
          }

        }

        if(flag==0)
        {
            return -1;
        }
       return result;

    }
}
