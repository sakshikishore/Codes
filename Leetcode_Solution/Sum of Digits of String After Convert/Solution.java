class Solution {
    public int getLucky(String s, int k) {
        String str="";
        int ans=0;
     for(int i=0;i<s.length();i++)
     {
         str=str+Integer.toString((s.charAt(i)-'a')+1);
     }
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<str.length();j++)
            {
                ans=ans+Integer.parseInt(str.substring(j,j+1));
            }
            
            if(ans<10)
            {
                break;
            }
            else
            {
                if(i+1<k)
                {
                  str=Integer.toString(ans); 
                  ans=0;
                
                }
            }
        }
        
        return ans;
        
    }
}
