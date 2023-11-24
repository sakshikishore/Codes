class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<dislikes.length;i++)
        {
            if(!h.containsKey(dislikes[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(dislikes[i][1]);
                h.put(dislikes[i][0],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(dislikes[i][0]);
                l.add(dislikes[i][1]);
                h.put(dislikes[i][0],l);
            }
            if(!h.containsKey(dislikes[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(dislikes[i][0]);
                h.put(dislikes[i][1],l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(dislikes[i][1]);
                l.add(dislikes[i][0]);
                h.put(dislikes[i][1],l);
            }
        }
        int color[]=new int[n+1]; // 1 or 2
        for(int i=1;i<=n;i++)
        {
            if(color[i]==0)
            {
                color[i]=1;
                Queue<Integer> q=new LinkedList<Integer>();
                q.add(i);
                while(q.size()>0)
                {
                    int x=q.poll();
                    int c=color[x];
                    if(h.containsKey(x))
                    {
                       ArrayList<Integer> list=h.get(x);
                       for(int j=0;j<list.size();j++)
                       {
                           int p=list.get(j);
                           if(color[p]==0)
                           {
                                 if(c==1)
                                 {
                                     color[p]=2;
                                 }
                                 else
                                 {
                                     color[p]=1;
                                 }
                                 q.add(p);
                           }
                           else
                           {
                               if(color[p]==c)
                               {
                                   return false;
                               }
                           }
                       }
                    }
                }
            }
        }

        return true;
    }
}
