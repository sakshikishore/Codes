class Solution {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
        int count=0;
        for(int i=0;i<connections.length;i++)
        {
            if(!h1.containsKey(connections[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(connections[i][0]);
                h1.put(connections[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h1.get(connections[i][1]);
                l.add(connections[i][0]);
                h1.put(connections[i][1],l);
            }
             if(!h2.containsKey(connections[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(connections[i][1]);
                h2.put(connections[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h2.get(connections[i][0]);
                l.add(connections[i][1]);
                h2.put(connections[i][0],l);
            }
        }
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            if(!h.contains(i))
            {
                h.add(i);
                Queue<Integer> q=new LinkedList<Integer>();
                q.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                    if(h1.containsKey(x))
                    {
                        ArrayList<Integer> l=h1.get(x);
                        for(int k=0;k<l.size();k++)
                        {
                            if(!h.contains(l.get(k)))
                            {
                                h.add(l.get(k));
                                q.add(l.get(k));
                            }
                        }
                    }
                    if(h2.containsKey(x))
                    {
                        ArrayList<Integer> l=h2.get(x);
                        for(int k=0;k<l.size();k++)
                        {
                            if(!h.contains(l.get(k)))
                            {
                                h.add(l.get(k));
                                count++;
                                q.add(l.get(k));
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
