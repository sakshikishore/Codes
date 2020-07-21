class Solution {
    public String generateTheString(int n) {
        String str="";
        if(n%2==0)
        {
            for(int i=0;i<n-1;i++)
            {
                str=str+"a";
            }
            
            str=str+"b";
                
        }
        else
        {
             for(int i=0;i<n;i++)
            {
                str=str+"a";
            }
            
        }
        
        return str;
    }
}
