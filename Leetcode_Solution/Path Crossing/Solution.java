class Solution {
    public boolean isPathCrossing(String path) {
        boolean result=false;
        int ch[]=new int[4];
        
        for(int i=0;i<path.length();i++)
        {
            if(i>0 && path.charAt(i)=='N' && path.charAt(i-1)=='S')
            {
                result=true;
                break;
            }
            else if(i>0 && path.charAt(i)=='S' && path.charAt(i-1)=='N')
            {
                result=true;
                break;
            }
            else if(i>0 && path.charAt(i)=='E' && path.charAt(i-1)=='W')
            {
                 result=true;
                 break;
            }
            else if(i>0 && path.charAt(i)=='W' && path.charAt(i-1)=='E')
            {
                 result=true;
                 break;
            }
            else
            {
                if(path.charAt(i)=='N')
                {
                    ch[0]++;
                }
                else if(path.charAt(i)=='S')
                {
                    ch[1]++;
                }
                 else if(path.charAt(i)=='W')
                {
                    ch[2]++;
                }
                 else
                {
                    ch[3]++;
                }
                
                if(ch[0]==ch[1]  && ch[2]==ch[3])
                {
                    result=true;
                    break;
                }
                    
            }
        }
        
        return result;
        
    }
}
