class Node
{
    int r ,cost;
    public Node(int a, int p)
    {
        r=a;
        cost=p;
    }
}
class Graph {
    HashMap<Integer,ArrayList<Node>> map;
    int m=0;
    public Graph(int n, int[][] edges) {
        map=new HashMap<Integer,ArrayList<Node>>();
        m=n;
        for(int i=0;i<edges.length;i++)
        {
            if(!map.containsKey(edges[i][0]))
            {
                ArrayList<Node> list=new ArrayList<Node>();
                list.add(new Node(edges[i][1],edges[i][2]));
                map.put(edges[i][0],list);
            }
            else
            {

                ArrayList<Node> list=map.get(edges[i][0]);
                list.add(new Node(edges[i][1],edges[i][2]));
                map.put(edges[i][0],list);
            }
        }
    }
    
    public void addEdge(int[] edge) {
        if(!map.containsKey(edge[0]))
            {
                ArrayList<Node> list=new ArrayList<Node>();
                list.add(new Node(edge[1],edge[2]));
                map.put(edge[0],list);
            }
            else
            {

                ArrayList<Node> list=map.get(edge[0]);
                list.add(new Node(edge[1],edge[2]));
                map.put(edge[0],list);
            }
    }
    
    public int shortestPath(int node1, int node2) {
        int result=Integer.MAX_VALUE;
        int arr[]=new int[m];
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(node1);
        h.put(node1,0);
        arr[node1]=1;
        while(q.size()>0)
        {
             int x=q.poll();
             arr[x]=0;
             if(x==node2)
             {
                if(h.get(x)<result)
                {
                 result=h.get(x);
                }
             }
             else
             {
                if(map.containsKey(x))
                {
                    ArrayList<Node> list=map.get(x);
                    for(int i=0;i<list.size();i++)
                    {
                        Node node=list.get(i);
                        int a=node.r;
                        if(h.containsKey(a))
                        {
                            if(h.get(a)>node.cost+h.get(x))
                            {
                                h.put(a,node.cost+h.get(x));
                                if(arr[a]==0)
                                {
                                    arr[a]=1;
                                    q.add(a);
                                }
                            }
                        }
                        else
                        {
                             h.put(a,node.cost+h.get(x));
                              arr[a]=1;
                              q.add(a);
                        }
                    }
                }
             }
        }
        if(result==Integer.MAX_VALUE)
        {
            return -1;
        }

        return result;
    }
}
