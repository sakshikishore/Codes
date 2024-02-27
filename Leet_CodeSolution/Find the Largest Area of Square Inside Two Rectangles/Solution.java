class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max=0;
        for(int i=0;i<bottomLeft.length;i++)
        {
            
            for(int j=i+1;j<bottomLeft.length;j++)
            {
                long x=Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                long y=Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                if(x>=0 && y>=0)
                { 
                    
                    if(x==y)
                    {
                        if(x*y>max)
                        {
                            max=x*y;
                        }
                    }
                    else
                    {
                        long p=Math.min(x,y);
                        if(p*p>max)
                        {
                            max=p*p;
                        }
                    }
                     
                 }
            }
        }
        
        return max;
    }
}
