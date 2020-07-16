class Solution {
    public int compress(char[] chars) {
        int count=1;
        int j=0;
        chars[j]=chars[0];
     for(int i=1;i<chars.length;i++)
     {
         if(chars[i]==chars[i-1])
         {
             count++;
         }
         else
         {
            
             if(count>1)
             {
                 String p=Integer.toString(count);
                 for(int k=0;k<p.length();k++)
                 {
                     j++;
                     chars[j]=p.charAt(k);
                    
                 }
             }
             j++;
             chars[j]=chars[i];
             count=1;
             
         }
     }
        
        if(count>1)
        {
            String p=Integer.toString(count);
                 for(int k=0;k<p.length();k++)
                 {
                     j++;
                     chars[j]=p.charAt(k);
                    
                 }
        }
       
           
        return j+1;
    }
}
