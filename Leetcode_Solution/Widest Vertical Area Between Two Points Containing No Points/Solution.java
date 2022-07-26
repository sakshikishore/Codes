class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<points.length;i++)
        {
            if(points[i][1]!=0)
            {
                l.add(points[i][0]);
            }
        }
        Collections.sort(l);
        int max=0;
        for(int i=1;i<l.size();i++)
        {
          if(l.get(i)-l.get(i-1)>max)
          {
              max=l.get(i)-l.get(i-1);
          }
        }
        return max;
    }
}
