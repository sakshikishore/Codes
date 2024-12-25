class Node
{
    int y,time;
    public Node(int candidate, int t)
    {
          y=candidate;
          time=t;
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int arr[]=new int[n];
        List<Integer> result=new ArrayList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        map.put(firstPerson,0);
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        q.add(firstPerson);
        arr[0]=1;
        arr[firstPerson]=1;
        HashMap<Integer,ArrayList<Node>> h=new HashMap<Integer,ArrayList<Node>>();
        for(int i=0;i<meetings.length;i++)
        {
            if(!h.containsKey(meetings[i][0]))
            {
                ArrayList<Node> l=new ArrayList<Node>();
                l.add(new Node(meetings[i][1],meetings[i][2]));
                h.put(meetings[i][0],l);
            }
            else
            {
                ArrayList<Node> l=h.get(meetings[i][0]);
                l.add(new Node(meetings[i][1],meetings[i][2]));
                 h.put(meetings[i][0],l);
            }
             if(!h.containsKey(meetings[i][1]))
            {
                ArrayList<Node> l=new ArrayList<Node>();
                l.add(new Node(meetings[i][0],meetings[i][2]));
                h.put(meetings[i][1],l);
            }
            else
            {
                ArrayList<Node> l=h.get(meetings[i][1]);
                l.add(new Node(meetings[i][0],meetings[i][2]));
                 h.put(meetings[i][1],l);
            }
        }

        while(q.size()>0)
        {
            int x=q.poll();
            int time=map.get(x);
            arr[x]=0;
            if(h.containsKey(x))
            {
                ArrayList<Node> l=h.get(x);
                for(int i=0;i<l.size();i++)
                {
                    Node node=l.get(i);
                    if(!map.containsKey(node.y) && node.time>=time)
                    {
                         map.put(node.y,node.time);
                          q.add(node.y);
                         arr[node.y]=1;
                    }
                    else
                    {
                        if(node.time>=time)
                        {
                            if(map.containsKey(node.y))
                            {
                                int t=map.get(node.y);
                                if(t>node.time)
                                 {
                                    if(arr[node.y]==0)
                                    {
                                        arr[node.y]=1;
                                        q.add(node.y);
                                    }
                                     map.put(node.y,node.time);
                                 }
                            }
                        }
                    }
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            result.add(entry.getKey());
        }

        return result;


    }
}
