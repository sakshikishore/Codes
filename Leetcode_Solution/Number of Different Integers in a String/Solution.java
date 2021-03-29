class Solution {
    public int numDifferentIntegers(String word) {
        String str="";
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>='0' && word.charAt(i)<='9')
            {
                str=str+word.substring(i,i+1);
            }
            else
            {
                str=str+" ";
            }
        }
        String p[]=str.trim().split("\\s+");
        TreeSet<String> t=new TreeSet<String>();
            for(int i=0;i<p.length;i++)
            {
                
                if(p[i].length()>0)
                {
                     int j=0;
                     if(p[i].charAt(0)=='0')
                     {
                         j=1;
                         while(p[i].length()>j && p[i].charAt(j)=='0')
                         {
                              j++;
                         }
                     }
                    if(j>0)
                    {
                        String r=p[i].substring(j);
                        t.add(r);
                    }
                    else
                    {
                       
                         t.add(p[i]);
                    }

                     
                }
            }
    
        
        return t.size();
        
    }
}
