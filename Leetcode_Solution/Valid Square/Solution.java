class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean result=false;
        if(Arrays.equals(p1,p2) || Arrays.equals(p2,p3) || Arrays.equals(p3,p4) || Arrays.equals(p1,p4) || Arrays.equals(p1,p3) || Arrays.equals(p2,p4))
        {
            return false;
        }
        int x=p1[0]-p2[0];
        int y=p1[1]-p2[1];
        
        int AB=(x*x)+(y*y);
         x=p1[0]-p3[0];
         y=p1[1]-p3[1];
        int AC=(x*x)+(y*y);
        
         x=p1[0]-p4[0];
         y=p1[1]-p4[1];
        int AD=(x*x)+(y*y);
        if(AB==AC || AB==AD || AC==AD)
        {
            if(AB==AC)
            {
                x=p4[0]-p3[0];
                y=p4[1]-p3[1];
                int CD=(x*x)+(y*y);
        
                 x=p4[0]-p2[0];
                 y=p4[1]-p2[1];
                int BD=(x*x)+(y*y);
                if(BD==CD && BD==AB)
                {
                    if(AC+CD==AD)
                    {
                      result=true;
                    }
                }
            }
           else if(AB==AD)
            {
                x=p2[0]-p3[0];
                y=p2[1]-p3[1];
                int BC=(x*x)+(y*y);
        
                 x=p4[0]-p3[0];
                 y=p4[1]-p3[1];
                int CD=(x*x)+(y*y);
                if(BC==CD && BC==AB)
                {
                    if(AC==(AD+CD))
                    {
                      result=true;
                    }
                }
            }
           else if(AC==AD)
            {
                x=p2[0]-p3[0];
                y=p2[1]-p3[1];
                int BC=(x*x)+(y*y);
        
                 x=p4[0]-p2[0];
                 y=p4[1]-p2[1];
                int BD=(x*x)+(y*y);
                if(BC==BD && BC==AC)
                {
                   if(AD+BD==AB)
                   {
                    result=true;
                   }
                }
                
            }
        }
        
        return result;
        
    }
}
