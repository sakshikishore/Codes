class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<bombs.length;i++)
        {
            long x1=bombs[i][0];
            long y1=bombs[i][1];
            long r1=bombs[i][2];
            for(int j=0;j<bombs.length;j++)
            {
                if(j!=i)
                {
                    long x2=bombs[j][0];
                    long y2=bombs[j][1];
                    double c1c2=Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
                    if(c1c2<=r1)
                    {
                        if(!h.containsKey(i))
                        {
                            ArrayList<Integer> l=new ArrayList<Integer>();
                            l.add(j);
                            h.put(i,l);
                        }
                        else
                        {
                            ArrayList<Integer> l=h.get(i);
                            l.add(j);
                            h.put(i,l);
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<bombs.length;i++)
        {
           HashSet<Integer> hset=new HashSet<Integer>();
                int count=1;
                hset.add(i);
                Queue<Integer> q=new LinkedList<Integer>();
                q.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                    if(h.containsKey(x))
                    {
                        ArrayList<Integer> l=h.get(x);
                        for(int j=0;j<l.size();j++)
                        {
                            int p=l.get(j);
                            if(!hset.contains(p))
                            {
                                hset.add(p);
                                q.add(p);
                                count++;
                            }
                        }
                    }

                }
                if(count>max)
                {
                    max=count;
                }
        }

        return max;
    }
}
