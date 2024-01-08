class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal=0.0;
        int area=0;
        for(int i=0;i<dimensions.length;i++)
        {
            double diagonal=Math.sqrt((dimensions[i][0]*dimensions[i][0])+(dimensions[i][1]*dimensions[i][1]));
            if(diagonal>maxDiagonal)
            {
                maxDiagonal=diagonal;
                area=dimensions[i][0]*dimensions[i][1];
            }
            else if(diagonal==maxDiagonal)
            {
                if(dimensions[i][0]*dimensions[i][1]>area)
                {
                     area=dimensions[i][0]*dimensions[i][1];
                }
            }
        }
        
        return area;
    }
}
