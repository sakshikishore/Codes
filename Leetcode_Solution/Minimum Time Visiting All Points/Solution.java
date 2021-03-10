class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x=points[0][0];
        int y=points[0][1];
        int count=0;
        for(int i=1;i<points.length;i++)
        {
            while(x!=points[i][0] || y!=points[i][1])
            {
                int flag=0;
            if(points[i][0]>x)
            {
                x++;
                count++;
                flag=1;
            }
            else if(points[i][0]<x)
            {
                x--;
                count++;
                flag=1;
            }
            if(points[i][1]>y)
            {
                y++;
                if(flag==0)
                {
                 count++;
                }
            }
            else if(points[i][1]<y)
            {
                y--;
                if(flag==0)
                {
                 count++;
                }
            }
            }
        }
        
        return count;
        
        
    }
}
