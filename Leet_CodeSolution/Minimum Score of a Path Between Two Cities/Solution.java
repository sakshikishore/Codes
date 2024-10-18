class Node
{
    int city2,score;
    public Node(int x,int y)
    {
        city2=x;
        score=y;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,ArrayList<Node>> h=new HashMap<Integer,ArrayList<Node>>();
       for(int i=0;i<roads.length;i++)
       {
         if(!h.containsKey(roads[i][0]))
         {
            ArrayList<Node> l=new ArrayList<Node>();
            l.add(new Node(roads[i][1],roads[i][2]));
            h.put(roads[i][0],l);
         }
         else
         {
             ArrayList<Node> l=h.get(roads[i][0]);
            l.add(new Node(roads[i][1],roads[i][2]));
            h.put(roads[i][0],l);
         }
          if(!h.containsKey(roads[i][1]))
         {
            ArrayList<Node> l=new ArrayList<Node>();
            l.add(new Node(roads[i][0],roads[i][2]));
            h.put(roads[i][1],l);
         }
         else
         {
             ArrayList<Node> l=h.get(roads[i][1]);
            l.add(new Node(roads[i][0],roads[i][2]));
            h.put(roads[i][1],l);
         }
       } 
       Queue<Integer> q=new LinkedList<Integer>();
       q.add(1);
       HashSet<Integer> hset=new HashSet<Integer>();
       hset.add(1);
       while(q.size()>0)
       {
        ArrayList<Node> l=h.get(q.poll());
        for(int i=0;i<l.size();i++)
        {
            Node p=l.get(i);
            if(p.score<min)
            {
                min=p.score;
            }
            if(!hset.contains(p.city2))
            {
                hset.add(p.city2);
                q.add(p.city2);
            }
        }
       }

       return min;
    }
}
