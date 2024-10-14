public class Node {
    int x;
    int y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}

class Solution {
    public int countHighestScoreNodes(int[] parents) {
        long max=0;
        HashMap<Integer,Node> map=new HashMap<Integer,Node>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        Queue<Integer> q=new LinkedList<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<parents.length;i++)
        {
            if(!h.containsKey(parents[i]))
            {

                h.put(parents[i],1);
            }
            else
            {
                h.put(parents[i],2);
            }
           hset.add(parents[i]);  
        }
        for(int i=0;i<parents.length;i++)
        {
          if(!hset.contains(i))
          {
            Node node=new Node(0,0);
            map.put(i,node);
            q.add(i);
          }
        }
        hset=new HashSet<Integer>();
        int count=0;
        while(q.size()>0)
        {
            int m=q.poll();
            Node node=map.get(m);
            long p=1;
            int c=node.x+node.y+1;
            if(node.x!=0)
            {
                p=p*node.x;
            }
            if(node.y!=0)
            {
                p=p*node.y;
            }
            if(parents.length-c!=0)
            {
                p=p*(parents.length-c);
            }
            if(p>max)
            {
                count=1;
                max=p;
            }
            else if(p==max)
            {
                count++;
            }
            if(parents[m]!=-1)
            {
                if(map.containsKey(parents[m]))
                {
                   Node n=map.get(parents[m]);
                   n.y=node.x+node.y+1;
                   map.put(parents[m],n);
                   q.add(parents[m]);
                }
                else
                {
                   int z=node.x+node.y+1;
                   Node n=new Node(z,0);
                    map.put(parents[m],n);
                   if(h.get(parents[m])==1)
                   {
                      q.add(parents[m]);
                   }
                }
            }
            
        }
        return count;
    }
}
