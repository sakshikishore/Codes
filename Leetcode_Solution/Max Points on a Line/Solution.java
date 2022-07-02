class Solution {
    public int maxPoints(int[][] points) {
        int max=1;
        for(int i=0;i<points.length-1;i++)
        {
            int count=0;
            HashMap<Double,Integer> h=new HashMap<Double,Integer>();
            int infinity=0;
            for(int j=i+1;j<points.length;j++)
            {
                if(points[j][1]==points[i][1])
                {
                    infinity++;
                    if(infinity+1>count)
                    {
                        count=infinity+1;
                    }
                }
                else
                {
        double x=(points[j][0]-points[i][0])/((points[j][1]-points[i][1])*1.0);
              if(x==-0.0)
              {
                  x=0.0;
              }
              if(!h.containsKey(x))
              {
                  h.put(x,2);
                  if(max<2)
                  {
                      max=2;
                  }
              }
              else
              {
                  h.put(x,h.get(x)+1);
                  if(h.get(x)>count)
                  {
                      count=h.get(x);
                  }
              }
            }
            if(count>max)
            {
                max=count;
            }
            if(max==points.length)
            {
                break;
            }
        }
        }
        
        return max;
        
    }
}
