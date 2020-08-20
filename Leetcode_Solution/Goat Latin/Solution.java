class Solution {
    public String toGoatLatin(String S) {
        String str="";
        String k="";
        if(S.length()>0)
        {
            String p[]=S.split(" ");
            for(int i=0;i<p.length;i++)
            {
               k=k+"a";
                if(p[i].substring(0,1).matches("[aeiouAEIOU]"))
                {
                    
                    p[i]=p[i]+"ma"+k;
                                            
                }
                else
                {
                    p[i]=p[i].substring(1)+p[i].substring(0,1)+"ma"+k;
                }
            }
            for(int i=0;i<p.length;i++)
            {
                if(i<p.length-1)
                {
                str=str+p[i]+" ";
                }
                else
                {
                    str=str+p[i];
                }
            }
        
        }
        
        return str;
       
        
    }
}
