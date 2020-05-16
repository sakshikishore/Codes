class Solution {
    public boolean validPalindrome(String s) {
        
        boolean result=true;
        if(s.length()>1)
        {
            for(int i=0;i<s.length()/2;i++)
            {
                
                if(s.charAt(i)!=s.charAt(s.length()-1-i))
                {
                  
                    String p=s.substring(i+1,s.length()-i);
                    StringBuffer sb=new StringBuffer(p);
                    String str=new String(sb.reverse());
                    if(!str.equals(p))
                    {
                    
                       String k=s.substring(i,s.length()-i-1);
                       StringBuffer sr=new StringBuffer(k);
                       String st=new String(sr.reverse());
                        if(!st.equals(k))
                        {
                            result=false;
                           
                        }
                    }
                    
                    break;
                }
            }
        }
                            
        return result;
        
    }
}
