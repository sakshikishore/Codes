class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        int result=0;
        for(int i=0;i<edges.length;i++)
        {
            if(!h.containsKey(edges[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(edges[i][0]);
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
                l.add(edges[i][1]);
                h.put(edges[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(edges[i][1]);
                l.add(edges[i][0]);
                h.put(edges[i][1],l);
            }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(i) && !hset.contains(i))
            {
                ArrayList<Integer> l=h.get(i);
                Collections.sort(l);
                int flag=0;
                for(int j=0;j<l.size();j++)
                {
                    hset.add(l.get(j));
                    if(flag==0)
                    {
                        if(l.get(j)!=i)
                        {
                            int x=l.get(j);
                            ArrayList<Integer> al=h.get(x);
                            if(al.size()!=l.size())
                            {
                                flag=1;
                            }
                            else
                            {
                                Collections.sort(al);
                                for(int k=0;k<l.size();k++)
                                {
                                   if(l.get(k)!=al.get(k))
                                   {
                                       flag=1;
                                       break;
                                   }
                                }
                            }
                        }
                    }
                }

                if(flag==0)
                {
                    result++;
                }
            }
            else if(!h.containsKey(i))
            {
                result++;
            }
        }

        return result;
    }
}
