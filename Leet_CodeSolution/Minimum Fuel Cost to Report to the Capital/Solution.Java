public class Node
{
    int car,seatLeft,totalCity;
    long fuel;
    public Node(int c,long f,int s,int tc)
    {
       car=c;
       fuel=f;
       seatLeft=s;
       totalCity=tc;
    }
}
class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {     
        long result=0;
    HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
    for(int i=0;i<roads.length;i++)
    {
        if(!h1.containsKey(roads[i][0]))
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(roads[i][1]);
            h1.put(roads[i][0],l);
        }
        else
        {
            ArrayList<Integer> l=h1.get(roads[i][0]);
            l.add(roads[i][1]);
            h1.put(roads[i][0],l);
        }
         if(!h1.containsKey(roads[i][1]))
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(roads[i][0]);
            h1.put(roads[i][1],l);
        }
        else
        {
            ArrayList<Integer> l=h1.get(roads[i][1]);
            l.add(roads[i][0]);
            h1.put(roads[i][1],l);
        }
    }

   if(!h1.containsKey(0))
   {
     return 0;
   }
   HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
   HashMap<Integer,Integer> childParent=new HashMap<Integer,Integer>();
   HashMap<Integer,Node> h2=new HashMap<Integer,Node>();
   Queue<Integer> q=new LinkedList<Integer>();
   q.add(0);
   HashSet<Integer> hset=new HashSet<Integer>();
   hset.add(0);
   while(q.size()>0)
   {
     int x=q.poll();
      ArrayList<Integer> l=h1.get(x);
      ArrayList<Integer> al=new ArrayList<Integer>();
      for(int i=0;i<l.size();i++)
      {
        if(!hset.contains(l.get(i)))
        {
            hset.add(l.get(i));
            al.add(l.get(i));
            q.add(l.get(i));
            childParent.put(l.get(i),x);
        }
      }
      if(al.size()>0)
      {
        h.put(x,al);
      }
   }
   for(int i=0;i<h1.size();i++)
   {
        if(!h.containsKey(i))
        {
            h2.put(i,new Node(1,0,seats-1,1));
            q.add(i);
        }
   }
    while(q.size()>0)
    {
        int y=q.poll();
        Node node=h2.get(y);
        if(childParent.get(y)==0)
        {
            //System.out.println(y+" "+(node.fuel+node.car));
            result+=node.fuel+node.car;
        }
        else
        {
            int parent=childParent.get(y);
            ArrayList<Integer> alist=h.get(parent);
            alist.remove(new Integer(y));
            if(h2.containsKey(parent))
            {
               Node node2=h2.get(parent);
               node2.fuel+=node.fuel+node.car;
               node2.totalCity+=node.totalCity;
               if(node2.totalCity%seats==0)
               {
                 node2.car=node2.totalCity/seats;
               }
               else
               {
                node2.car=(node2.totalCity/seats)+1;
               }
               node2.seatLeft=node2.car*seats-node2.totalCity;
               h2.put(parent,node2);
              
            }
            else
            {
                 if(node.seatLeft==0)
                {
                  
                    h2.put(parent,new Node(node.car+1,node.fuel+node.car,seats-1,node.totalCity+1));
                }
                else
                {
                     h2.put(parent,new Node(node.car,node.fuel+node.car,node.seatLeft-1,node.totalCity+1));
                }
               
            }
            if(alist.size()==0)
            {
                node=h2.get(parent);
                q.add(parent);
                h.remove(parent);
            }
        }
    }

    return result;

    }
}
