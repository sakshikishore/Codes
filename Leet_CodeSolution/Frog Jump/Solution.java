class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]!=1)
        {
            return false;
        }
        int n=stones[stones.length-1];
        if(n==1)
        {
            return true;
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<stones.length;i++)
        {
            hset.add(stones[i]);
        }
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        h.put(1,l);
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(1);
        while(q.size()>0)
        {
            int p=q.poll();
            if(p==n)
            {
                return true;
            }
            ArrayList<Integer> al=h.get(p);
            for(int j=0;j<al.size();j++)
            {
                int r=al.get(j);
                int x=p+r;
                if(hset.contains(x))
                {
                    if(h.containsKey(x))
                    {
                        l=h.get(x);
                        if(r-1!=0)
                        {
                            if(!l.contains(r-1))
                            {
                             l.add(r-1);
                            }
                        }
                        if(!l.contains(r))
                            {
                             l.add(r);
                            }
                        if(!l.contains(r+1))
                            {
                             l.add(r+1);
                            }
                        h.put(x,l);
                    }
                    else
                    {
                        q.add(x);
                        l=new ArrayList<Integer>();;
                        if(r-1!=0)
                        {
                            if(!l.contains(r-1))
                            {
                             l.add(r-1);
                            }
                        }
                        if(!l.contains(r))
                            {
                             l.add(r);
                            }
                        if(!l.contains(r+1))
                            {
                             l.add(r+1);
                            }
                        h.put(x,l);
                    }
                }
            }
 
        }

        return false;
        
    }
}
