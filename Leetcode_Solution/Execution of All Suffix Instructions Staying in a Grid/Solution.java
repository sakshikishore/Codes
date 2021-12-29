class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int arr[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            int x=startPos[0];
            int y=startPos[1];
            int count=0;
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(j)=='R')
                {
                    y=y+1;
                    if(y<n)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                else if(s.charAt(j)=='U')
                {
                    x=x-1;
                    if(x>=0)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                 else if(s.charAt(j)=='D')
                {
                    x=x+1;
                    if(x<n)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    y=y-1;
                    if(y>=0)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            arr[i]=count;
            
        }
        
        return arr;
        
    }
}
