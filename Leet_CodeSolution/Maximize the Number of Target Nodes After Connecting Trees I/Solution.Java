public class Node
{
    int ele,count;
    public Node(int e, int cnt)
    {
        ele=e;
        count=cnt;
    }
}
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<edges1.length;i++)
        {
           if(!h1.containsKey(edges1[i][0]))
           {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(edges1[i][1]);
            h1.put(edges1[i][0],l);
           }
           else
           {
            ArrayList<Integer> l=h1.get(edges1[i][0]);
            l.add(edges1[i][1]);
            h1.put(edges1[i][0],l);
           }
           if(!h1.containsKey(edges1[i][1]))
           {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(edges1[i][0]);
            h1.put(edges1[i][1],l);
           }
           else
           {
            ArrayList<Integer> l=h1.get(edges1[i][1]);
            l.add(edges1[i][0]);
            h1.put(edges1[i][1],l);
           }
        }
        int arr[]=new int[edges1.length+1];
        for(int i=0;i<=edges1.length;i++)
        {
            Queue<Node> q=new LinkedList<Node>();
            q.add(new Node(i,0));
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(i);
            while(q.size()>0)
            {
                    Node node=q.poll();
                    if(node.count<=k)
                    {
                        arr[i]++;
                    }
                    ArrayList<Integer> l=h1.get(node.ele);
                    for(int j=0;j<l.size();j++)
                    {
                        if(!hset.contains(l.get(j)))
                        {
                            q.add(new Node(l.get(j),node.count+1));
                            hset.add(l.get(j));
                        }
                    }
            }
        }

        HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<edges2.length;i++)
        {
           if(!h2.containsKey(edges2[i][0]))
           {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(edges2[i][1]);
            h2.put(edges2[i][0],l);
           }
           else
           {
            ArrayList<Integer> l=h2.get(edges2[i][0]);
            l.add(edges2[i][1]);
            h2.put(edges2[i][0],l);
           }
           if(!h2.containsKey(edges2[i][1]))
           {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(edges2[i][0]);
            h2.put(edges2[i][1],l);
           }
           else
           {
            ArrayList<Integer> l=h2.get(edges2[i][1]);
            l.add(edges2[i][0]);
            h2.put(edges2[i][1],l);
           }
        }
        int max=0;
        for(int i=0;i<=edges2.length;i++)
        {
            Queue<Node> q=new LinkedList<Node>();
            q.add(new Node(i,0));
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(i);
            int m=0;
            while(q.size()>0)
            {
                    Node node=q.poll();
                    if(node.count<k)
                    {
                        m++;
                    }
                    ArrayList<Integer> l=h2.get(node.ele);
                    for(int j=0;j<l.size();j++)
                    {
                        if(!hset.contains(l.get(j)))
                        {
                            q.add(new Node(l.get(j),node.count+1));
                            hset.add(l.get(j));
                        }
                    }
            }
            if(m>max)
            {
                max=m;
            }
        }
       for(int i=0;i<arr.length;i++)
       {
         arr[i]+=max;
       }
        return arr;
    }
}
