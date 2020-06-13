class Solution {
    public boolean isBoomerang(int[][] p) {
        boolean result=true;
        double AB,BC,AC;
        double points[][]=new double[3][2];
        for(int i=0;i<3;i++)
        {
            points[i][0]=p[i][0];
            points[i][1]=p[i][1];
        }
   
        if((points[0][0]==points[1][0] && points[0][1]==points[1][1])||(points[0][0]==points[2][0] && points[0][1]==points[2][1])||(points[1][0]==points[2][0] && points[1][1]==points[2][1]))
        {
            result=false;
        }
        if(result==true)
        {
            try
            {
             AB=(points[1][1]-points[0][1])/(points[1][0]-points[0][0]);
            }
            catch(Exception e)
            {
                AB=-1;
            }
            try
            {
             BC=(points[2][1]-points[1][1])/(points[2][0]-points[1][0]);
            }
             catch(Exception e)
            {
                BC=-1;
            }
            try
            {
             AC=(points[2][1]-points[0][1])/(points[2][0]-points[0][0]);
            }
            catch(Exception e)
            {
                AC=-1;
            }
            if(AB==BC && AB==AC)
            {
                result=false;
            }
        }
 
        return result;
    }
}
