class Solution {
    public int numSimilarGroups(String[] strs) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<strs.length;j++)
            {
               if(j!=i)
               {
                   int count=0;
                   for(int k=0;k<strs[i].length();k++)
                   {
                       if(strs[i].charAt(k)!=strs[j].charAt(k))
                       {
                           count++;
                           if(count>2)
                           {
                               break;
                           }
                       }
                   }
                   if(count<3)
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
        HashSet<Integer> hset=new HashSet<Integer>();
        int result=0;
        for(int i=0;i<strs.length;i++)
        {
            if(!hset.contains(i))
            {
                Queue<Integer> q=new LinkedList<Integer>();
                result++;
                q.add(i);
                hset.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                    if(h.containsKey(x))
                    {
                        ArrayList<Integer> l=h.get(x);
                        for(int j=0;j<l.size();j++)
                        {
                            if(!hset.contains(l.get(j)))
                            {
                                  q.add(l.get(j));
                                  hset.add(l.get(j));
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
