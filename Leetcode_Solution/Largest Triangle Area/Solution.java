class Solution {
    public double largestTriangleArea(int[][] points) {
        double result=0.0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                for(int k=j+1;k<points.length;k++)
                {
                    if(points[i][0]!=points[j][0] || points[j][0]!=points[k][0])
                    {
                        if(points[i][1]!=points[j][1] || points[j][1]!=points[k][1])
                        {
                            int ax=points[i][0];
                            int bx=points[j][0];
                            int cx=points[k][0];
                            int ay=points[i][1];
                            int by=points[j][1];
                            int cy=points[k][1];
                            int ab=(bx-ax)*(bx-ax) + (by-ay)*(by-ay);
                            int ac=(cx-ax)*(cx-ax) + (cy-ay)*(cy-ay);
                            int bc=(cx-bx)*(cx-bx) + (cy-by)*(cy-by);
        
                            if(ab+ac==bc)
                                    {
                                    double area=0.5*(Math.sqrt(ab))*(Math.sqrt(ac));
                                        if(area>result)
                                        {
                                            result=area;
                                        }
                                    }
                                   else if(ab+bc==ac)
                                    {
                                      double area=0.5*(Math.sqrt(ab))*(Math.sqrt(bc)); 
                                        if(area>result)
                                        {
                                            result=area;
                                        } 
                                    }
                                    else if(bc+ac==ab)
                                    {
                                     double area=0.5*(Math.sqrt(bc))*(Math.sqrt(ac));
                                        if(area>result)
                                        {
                                            result=area;
                                        }
                                     }
                            else
                            {
                    double s=(Math.sqrt(ab)+Math.sqrt(bc)+Math.sqrt(ac))/2.0;
                                double area=Math.sqrt(s*(s-Math.sqrt(ab))*(s-Math.sqrt(bc))*(s-Math.sqrt(ac)));
                                    if(area>result)
                                    {
                                        result=area;
                                    }
                            }
                                    
                        }
                    }
                }
            }
        }
                                                      
                         return result;
        
    }
}
