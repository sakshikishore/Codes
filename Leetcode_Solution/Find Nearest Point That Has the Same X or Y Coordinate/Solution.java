class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min_distance=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<points.length;i++)
        {
            if(points[i][0]==x || points[i][1]==y)
            {
                int p=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(p<min_distance)
                {
                    min_distance=p;
                    index=i;
                }
            }
        }
      return index;  
    }
}
