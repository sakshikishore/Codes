public class Node
{
    int node,time,income;
    public Node(int n, int t,int p)
    {
        node=n;
        time=t;
        income=p;
    }
}
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int maxIncome=Integer.MIN_VALUE;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
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
        }
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        Queue<Integer> q=new LinkedList<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        HashMap<Integer,Integer> childParent=new HashMap<Integer,Integer>();
        q.add(0);
        hset.add(0);
        while(q.size()>0)
        {
            int x=q.poll();
            ArrayList<Integer> l=h.get(x);
            ArrayList<Integer> al=new ArrayList<Integer>();
            for(int i=0;i<l.size();i++)
            {
                if(!hset.contains(l.get(i)))
                {
                    hset.add(l.get(i));
                    q.add(l.get(i));
                    al.add(l.get(i));
                    childParent.put(l.get(i),x);
                }
            }
            if(al.size()!=0){
                h1.put(x,al);
            }
        }

        int time=0;
        HashMap<Integer,Integer> map=new  HashMap<Integer,Integer>(); // bob details || key=node || value=time
        map.put(bob,0);
        q=new LinkedList<Integer>();
        q.add(bob);
        while(q.size()>0)
        {
            int x=q.poll();
            if(childParent.containsKey(x))
            {
                q.add(childParent.get(x));
                map.put(childParent.get(x),map.get(x)+1);
            }
        }

       Queue<Node> q1=new LinkedList<Node>();
        q1.add(new Node(0,0,amount[0]));
        while(q1.size()>0)
        {
            Node x=q1.poll();
            int t=x.time;
            if(h1.containsKey(x.node))
            {
                ArrayList<Integer> l=h1.get(x.node);
                for(int i=0;i<l.size();i++)
                {
                    if(map.containsKey(l.get(i)))
                    {
                        if(map.get(l.get(i))==t+1)
                        {
                            q1.add(new Node(l.get(i),t+1,x.income+(amount[l.get(i)]/2)));
                        }
                        else if(map.get(l.get(i))>t+1)
                        {
                             q1.add(new Node(l.get(i),t+1,x.income+amount[l.get(i)]));
                        }
                        else
                        {
                            q1.add(new Node(l.get(i),t+1,x.income));
                        }
                    }
                    else
                    {
                        q1.add(new Node(l.get(i),t+1,x.income+amount[l.get(i)]));
                    }
                }
            }
            else
            {
                if(x.income>maxIncome)
                {
                    maxIncome=x.income;
                }
            }
        }

       return maxIncome;


    }
}
