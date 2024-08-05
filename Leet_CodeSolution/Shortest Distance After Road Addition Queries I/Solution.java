public class Node
{
    int node;
    int count;
    public Node(int city,int c)
    {
        node=city;
        count=c;
    }
}
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int result[]=new int[queries.length];
        HashMap<Integer,ArrayList<Integer>> h=new  HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n-1;i++)
        {
           ArrayList<Integer> l=new ArrayList<Integer>();
           l.add(i+1);
           h.put(i,l);
        }
        for(int i=0;i<queries.length;i++)
        {
            ArrayList<Integer> l1=h.get(queries[i][0]);
            l1.add(queries[i][1]);
            h.put(queries[i][0],l1);
            Queue<Node> q=new LinkedList<Node>();
            q.add(new Node(0,0));
            HashSet<Integer> hset=new HashSet<Integer>();
            result[i]=-1;
            hset.add(0);
            while(q.size()>0)
            {
                Node node=q.poll();
                ArrayList<Integer> l=h.get(node.node);
                for(int j=0;j<l.size();j++)
                {
                    if(!hset.contains(l.get(j)))
                    {
                        hset.add(l.get(j));
                        if(l.get(j)==n-1)
                        {
                        
                            result[i]= node.count+1;
                            break;

                        }
                        q.add(new Node(l.get(j),node.count+1));
                    }
                }
                if(result[i]!=-1)
                {
                    break;
                }
            }
        }

        return result;
    }
}
