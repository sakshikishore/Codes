public class Node
    {
        int dest,start,end;
        public Node(int d, int s, int e)
        {
            dest=d;
            start=s;
            end=e;
        }
    }
class Solution {
    public int minTime(int n, int[][] edges) {
        int flag=0;
        HashMap<Integer,ArrayList<Node>> h=new HashMap<Integer,ArrayList<Node>>();
        for(int i=0;i<edges.length;i++)
            {
                if(!h.containsKey(edges[i][0]))
                {
                    ArrayList<Node> l=new ArrayList<Node>();
                    Node node=new Node(edges[i][1],edges[i][2],edges[i][3]);
                    l.add(node);
                    h.put(edges[i][0],l);
                }
                else
                {
                    ArrayList<Node> l=h.get(edges[i][0]);
                    Node node=new Node(edges[i][1],edges[i][2],edges[i][3]);
                    l.add(node);
                    h.put(edges[i][0],l);
                }
            }
        HashMap<Integer,Integer> visited=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        map.put(0,1);
        int min=Integer.MAX_VALUE;
        visited.put(0,0);
        while(q.size()>0)
            {
                int ele=q.poll();
                map.put(ele,0);
                int time=visited.get(ele);
                if(ele==n-1)
                {
                    flag=1;
                    min=Math.min(time,min);
                }
                else
                {
                    if(h.containsKey(ele))
                    {
                        ArrayList<Node> l=h.get(ele);
                        for(int j=0;j<l.size();j++)
                            {
                                 int start=l.get(j).start;
                                    int end=l.get(j).end;
                                if(visited.containsKey(l.get(j).dest))
                                {
                                    int x=visited.get(l.get(j).dest);
                
                                    if(time<=end)
                                    {
                                        if(time>=start)
                                        {
                                                if(x>time+1)
                                                {
                                                    visited.put(l.get(j).dest,time+1);
                                                     if(map.get(l.get(j).dest)==0)
                                                    {
                                                        map.put(l.get(j).dest,1);
                                                        q.add(l.get(j).dest);
                                                    }
                                                }
                                            
                                        }
                                        else
                                        {
                                            int y=start-time;
                                            if(time+y+1<x)
                                            {
                                                visited.put(l.get(j).dest,time+1+y);
                                                     if(map.get(l.get(j).dest)==0)
                                                    {
                                                        map.put(l.get(j).dest,1);
                                                        q.add(l.get(j).dest);
                                                    }
                                            }
                                            
                                        }
                                    }
                                }
                                else
                                {
                                    if(time<=end)
                                    {
                                        if(time>=start)
                                        {
                                            q.add(l.get(j).dest);
                                            map.put(l.get(j).dest,1);
                                            visited.put(l.get(j).dest,time+1);
                                        }
                                        else
                                        {
                                            int y=start-time;
                                             q.add(l.get(j).dest);
                                            map.put(l.get(j).dest,1);
                                            visited.put(l.get(j).dest,time+1+y);
                                        }
                                    }
                                }
                            }
                    }
                }
                
            }

        if(flag==0)
        {
            return -1;
        }

        return min;
    }
}
