class Solution {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result[]=new int[intervals.length];
        TreeSet<Integer> t=new TreeSet<Integer>();
        for(int i=0;i<intervals.length;i++)
        {
            h.put(intervals[i][0],i);
            t.add(intervals[i][0]);
        }
        
        for(int i=0;i<intervals.length;i++)
        {
            int x=intervals[i][1];
            result[i]=-1;
            if(h.containsKey(x))
            {
                result[i]=h.get(x);
            }
            else
            {
                Iterator<Integer> itr=t.iterator();
                while(itr.hasNext())
                {
                    int y=itr.next();
                    if(y>x)
                    {
                        result[i]=h.get(y);
                        break;
                    }
                }
            }
        }
        
        return result;
        
    }
}
