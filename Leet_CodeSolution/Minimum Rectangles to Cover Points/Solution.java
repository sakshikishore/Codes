class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        TreeSet<Integer> t=new TreeSet<Integer>();
        for(int i=0;i<points.length;i++)
        {
            t.add(points[i][0]);
        }
        int count=0;
        Iterator<Integer> itr=t.iterator();
        int min=-1;
        while(itr.hasNext())
        {
             if(min==-1)
             {
                min=itr.next();
             }
             else
             {
                int p=itr.next();
                if(p-min>w)
                {
                    count++;
                    min=p;
                }
             }
        }

        return count+1;
    }
}
