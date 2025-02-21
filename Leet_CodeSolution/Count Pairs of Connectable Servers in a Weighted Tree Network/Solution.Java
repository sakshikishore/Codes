public class Node
{
    int ele,totalW;
    public Node(int e, int w)
    {
        ele=e;
        totalW=w;
    }

}
class Solution {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int result[]=new int[edges.length+1];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<Integer,HashMap<Integer,Integer>>();
        for(int i=0;i<edges.length;i++)
        {
            if(!h.containsKey(edges[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][1]);
                h.put(edges[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][0]);
                 l.add(edges[i][1]);
                h.put(edges[i][0],l);

            }
            if(!h.containsKey(edges[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][1]);
                 l.add(edges[i][0]);
                h.put(edges[i][1],l);

            }
            if(!map.containsKey(edges[i][0]))
            {
                HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
                h1.put(edges[i][1],edges[i][2]);
                map.put(edges[i][0],h1);
            }
            else
            {
                HashMap<Integer,Integer> h1=map.get(edges[i][0]);
                h1.put(edges[i][1],edges[i][2]);
                map.put(edges[i][0],h1);
            }
             if(!map.containsKey(edges[i][1]))
            {
                HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
                h1.put(edges[i][0],edges[i][2]);
                map.put(edges[i][1],h1);
            }
            else
            {
                HashMap<Integer,Integer> h1=map.get(edges[i][1]);
                h1.put(edges[i][0],edges[i][2]);
                map.put(edges[i][1],h1);
            }
        }
        for(int i=0;i<=edges.length;i++)
        {
           ArrayList<Integer> l=h.get(i);
           if(l.size()==1)
           {
             continue;
           }
           else
           {
              Queue<Node> q=new LinkedList<Node>();
              HashSet<Integer> hset=new HashSet<Integer>();
              hset.add(i);
              ArrayList<Integer> alist=new ArrayList<Integer>();
              for(int j=0;j<l.size();j++)
              {
                int c=0;
                int weight=map.get(i).get(l.get(j));
                if(weight%signalSpeed==0)
                {
                    c=1;
                }
                q.add(new Node(l.get(j),weight));
                hset.add(l.get(j));
                while(q.size()>0)
                {
                   Node node=q.poll();
                   ArrayList<Integer> al=h.get(node.ele);
                   for(int k=0;k<al.size();k++)
                   {
                      if(!hset.contains(al.get(k)))
                      {
                        hset.add(al.get(k));
                       int currentWeight=node.totalW+map.get(node.ele).get(al.get(k));
                        if(currentWeight%signalSpeed==0)
                        {
                            c++;
                        }
                        q.add(new Node(al.get(k),currentWeight));
                      }
                   }
                }

                if(c!=0)
                {
                    alist.add(c);
                }
              }
             if(alist.size()>1)
              {
                int count=0;
                   for(int y=0;y<alist.size();y++)
                   {
                    for(int z=y+1;z<alist.size();z++)
                    {
                        count+=alist.get(y)*alist.get(z);
                    }
                   }
                   result[i]=count;
              }
           }
        }

        return result;
    }
}
