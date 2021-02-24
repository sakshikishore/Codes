class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean result=true;
         for(int i=0;i<coordinates.length-1;i++)
         {
             if(coordinates[i][0]!=coordinates[i+1][0])
             {
                 result=false;
                 break;
             }
         }
        if(result==false)
        {
            result=true;
            for(int i=0;i<coordinates.length-1;i++)
             {
                 if(coordinates[i][1]!=coordinates[i+1][1])
                 {
                     result=false;
                     break;
                 }
             }
        }
        if(result==false)
        {
            result=true;
            int x0=coordinates[0][0];
            int y0=coordinates[0][1];
            int x1=coordinates[1][0];
            int y1=coordinates[1][1];
            for(int i=2;i<coordinates.length;i++)
            {
               if((x0-x1)*(y1-coordinates[i][1])!=(y0-y1)*(x1-coordinates[i][0]))
               {
                   result=false;
               }
            }
        }
        return result;
        
    }
}
