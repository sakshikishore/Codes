class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<quiet.length;i++)
        {
            h.put(quiet[i],i);
        }
        Arrays.sort(quiet);
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<richer.length;i++)
        {
            if(!map.containsKey(richer[i][0]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(richer[i][1]);
                map.put(richer[i][0],list);
            }
            else
            {
                ArrayList<Integer> list=map.get(richer[i][0]);
                list.add(richer[i][1]);
                map.put(richer[i][0],list);
               
            }
        }
        int result[]=new int[quiet.length];
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<result.length;i++)
        {
            int val=quiet[i];
            int x=h.get(val);
            if(!hset.contains(x))
            {
            result[x]=x;
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(x);
            hset.add(x);
            while(q.size()>0)
            {
                int n=q.poll();
                if(map.containsKey(n))
                {
                    ArrayList<Integer> l=map.get(n);
                    for(int j=0;j<l.size();j++)
                    {
                          int p=l.get(j);
                          if(!hset.contains(p))
                          {
                                result[p]=x;
                                hset.add(p);
                                if(hset.size()==result.length)
                                {
                                    break;
                                }
                                q.add(p);
                          }
                    }
                }
                if(hset.size()==result.length)
                                {
                                    break;
                                }

            }
            if(hset.size()==result.length)
                                {
                                    break;
                                }
            }
        }

        return result;

    }
}
