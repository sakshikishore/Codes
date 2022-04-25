class Solution {
    public int countBinarySubstrings(String s) {
        int c[]=new int[2],p=0;
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                if(p==1)
                {
                  if(c[0]>0 && c[1]>0)
                  {
                      result+=(int)Math.min(c[0],c[1]);
                  }
                  c[0]=1;
                  p=0;
                }
                else
                {
                    c[0]++;
                }
            }
            else
            {
                if(p==0)
                {
                  if(c[0]>0 && c[1]>0)
                  {
                      result+=(int)Math.min(c[0],c[1]);
                  }
                  c[1]=1;
                  p=1;
                }
                else
                {
                    c[1]++;
                }
            }
            
        }
                  if(c[0]>0 && c[1]>0)
                  {
                      result+=(int)Math.min(c[0],c[1]);
                  }
        
        
        return result;
        
    }
}
