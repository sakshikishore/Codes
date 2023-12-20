class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        {
            return -1;
        }
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<connections.length;i++)
        {
                if(!h.containsKey(connections[i][0]))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(connections[i][1]);
                    h.put(connections[i][0],list);
                }
                else
                {
                    ArrayList<Integer> list=h.get(connections[i][0]);
                    list.add(connections[i][1]);
                    h.put(connections[i][0],list);
                }
                if(!h.containsKey(connections[i][1]))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(connections[i][0]);
                    h.put(connections[i][1],list);
                }
                else
                {
                    ArrayList<Integer> list=h.get(connections[i][1]);
                    list.add(connections[i][0]);
                    h.put(connections[i][1],list);
                }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!hset.contains(i))
            {
                hset.add(i);
                count++;
                Queue<Integer> q=new LinkedList<Integer>();
                q.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                    if(h.containsKey(x))
                    {
                        ArrayList<Integer> list=h.get(x);
                        for(int j=0;j<list.size();j++)
                        {
                            if(!hset.contains(list.get(j)))
                            {
                                hset.add(list.get(j));
                                q.add(list.get(j));
                            }
                        }
                    }
                }
            }
        }

        return count-1;
    }
}
