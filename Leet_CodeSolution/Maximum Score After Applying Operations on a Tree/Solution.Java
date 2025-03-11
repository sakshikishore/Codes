public class Node {
    int ele;
    long totalSum, notPickScore, pickScore;

    public Node(int e, long tS, long nPS, long pS) {
        ele = e;
        totalSum = tS;
        notPickScore = nPS;
        pickScore = pS;
    }
}

class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            if (!h.containsKey(edges[i][0])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(edges[i][1]);
                h.put(edges[i][0], l);
            } else {
                ArrayList<Integer> l = h.get(edges[i][0]);
                l.add(edges[i][1]);
                h.put(edges[i][0], l);
            }
            if (!h.containsKey(edges[i][1])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(edges[i][0]);
                h.put(edges[i][1], l);
            } else {
                ArrayList<Integer> l = h.get(edges[i][1]);
                l.add(edges[i][0]);
                h.put(edges[i][1], l);
            }
        }
       HashMap<Integer,Integer> parentChildren=new HashMap<Integer,Integer>(); 
       HashMap<Integer,Integer> childFather=new HashMap<Integer,Integer>();
       HashMap<Integer,Node> map=new HashMap<Integer,Node>();
       Queue<Node> qu=new LinkedList<Node>();
       Queue<Integer> q=new LinkedList<Integer>();
       q.add(0);
       HashSet<Integer> hset=new HashSet<Integer>();
       hset.add(0);
       while(q.size()>0)
       {
          int x=q.poll();
          map.put(x,new Node(x,values[x]*1l,0*1l,values[x]*1l));
          ArrayList<Integer> l=h.get(x);
          int count=0;
          for(int i=0;i<l.size();i++)
          {
             if(!hset.contains(l.get(i)))
             {
                childFather.put(l.get(i),x);
                count++;
                q.add(l.get(i));
                hset.add(l.get(i));
             }
          }
          if(count>0)
          {
             parentChildren.put(x,count);
          }
          else
          {
             qu.add(new Node(x,values[x],0,0));
          }
       }

       while(qu.size()>0)
       {
          Node node=qu.poll();
          if(node.ele==0)
          {
            return Math.max(node.notPickScore,node.pickScore);
          }
          else
          {
            int parent=childFather.get(node.ele);
            Node nd=map.get(parent);
            nd.totalSum+=node.totalSum;
            nd.notPickScore+=node.totalSum;
            nd.pickScore+=Math.max(node.notPickScore,node.pickScore);
            if(parentChildren.get(parent)==1)
            {
              parentChildren.remove(parent);
              qu.add(nd);
            }
            else
            {
              parentChildren.put(parent,parentChildren.get(parent)-1);
            }

          }

       }

       return 0;


    }
}
