class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dist=Math.abs(sx-fx)+Math.abs(sy-fy);
        if(sx==fx && sy==fy && t==1)
        {
            return false;
        }
        if(dist<=t)
        {
            return true;
        }
        else
        {
            if(sx<fx)
            {
                int count=0;
                if(sy<fy)
                {
                    count=Math.min(fx-sx,fy-sy);
                    sx=sx+count;
                    sy=sy+count;

                }
                else
                {
                   
                   count=Math.min(fx-sx,sy-fy);
                    sx=sx+count;
                    sy=sy-count;
                }
               
                int p=Math.abs(fy-sy)+Math.abs(fx-sx);
                if(p+count<=t)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(sx>fx)
            {
                int count=0;
                if(sy>fy)
                {
                    count=Math.min(sx-fx,sy-fy);
                    sy=sy-count;
                    sx=sx-count;
                }
                else
                {
                   
                      count=Math.min(sx-fx, fy-sy);
                    sx=sx-count;
                    sy=sy+count;
    
                }
                int p=Math.abs(fy-sy)+Math.abs(fx-sx);
                if(p+count<=t)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
                
        }
        
        return false;
        
        
        
    }
}
