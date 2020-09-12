class Solution {
    public String countAndSay(int n) {
        String p="1";
        
        for(int i=2;i<=n;i++)
        {
          int count=1;
           String str="";
           for(int j=1;j<p.length();j++)
           {
               if(p.charAt(j-1)!=p.charAt(j))
               {
                       str=str+Integer.toString(count)+p.substring(j-1,j);
                       count=1;
               }
               else
               {
                   count++;
               }
           }
            
           str=str+Integer.toString(count)+p.substring(p.length()-1,p.length());
            p=str;
        }
        
        return p;
        
    }
}
