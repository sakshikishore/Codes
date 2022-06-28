class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length<3)
        {
            return 0;
        }
        else
        {
            int count=0;
            for(int i=0;i<points.length;i++)
            {
                for(int j=i+1;j<points.length;j++)
                {
                    for(int k=j+1;k<points.length;k++)
                    {
                        // jik
                            int x1=points[j][0]-points[i][0];
                            int y1=points[j][1]-points[i][1];
                            int ijDistance= (x1*x1)+(y1*y1);
                            int x2=points[j][0]-points[k][0];
                            int y2=points[j][1]-points[k][1];
                            int ikDistance= (x2*x2)+(y2*y2);
                        
                            if(ijDistance==ikDistance)
                            {
                                count=count+2;
                            }
                             //ijk
                             x1=points[i][0]-points[j][0];
                             y1=points[i][1]-points[j][1];
                             ijDistance= (x1*x1)+(y1*y1);

                             x2=points[i][0]-points[k][0];
                             y2=points[i][1]-points[k][1];
                             ikDistance= (x2*x2)+(y2*y2);
                            if(ijDistance==ikDistance)
                            {
                                count=count+2;
                            }
                        // kij
                             x1=points[i][0]-points[k][0];
                             y1=points[i][1]-points[k][1];
                             ijDistance= (x1*x1)+(y1*y1);

                             x2=points[j][0]-points[k][0];
                             y2=points[j][1]-points[k][1];
                             ikDistance= (x2*x2)+(y2*y2);
                            if(ijDistance==ikDistance)
                            {
                                count=count+2;
                            }
                        
                        
                    }
                }
            }
            
            return count;
        }
    }
}
