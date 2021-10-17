class Solution {
    public boolean areNumbersAscending(String s) {
        String p[]=s.split(" ");
        boolean result=true;
        int r=-1;
        for(int i=0;i<p.length;i++)
        {
           if(p[i].charAt(0)>='1' && p[i].charAt(0)<='9')
           {
               if(r>=Integer.parseInt(p[i]))
               {
                   result=false;
                   break;
               }
               else
               {
                   r=Integer.parseInt(p[i]);
               }
           }
        }
        
        return result;
        
    }
}
