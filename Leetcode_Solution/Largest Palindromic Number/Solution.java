class Solution {
    public String largestPalindromic(String num) {
        int ch[]=new int[10];
        
        for(int i=0;i<num.length();i++)
        {
            ch[num.charAt(i)-'0']++;
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        int max=-1;
        for(int i=9;i>=0;i--)
        {
            if(ch[i]%2==0)
            {
                int x=ch[i]/2;
                for(int j=0;j<x;j++)
                {
                    l.add(i);
                }
            }
            else if(ch[i]==1)
            {
                if(i>max)
                {
                    max=i;
                }
            }
            else
            {
                int p=ch[i]-1;
                int x=p/2;
                for(int j=0;j<x;j++)
                {
                    l.add(i);
                }
                if(i>max)
                {
                    max=i;
                }
            }
        }
        if(l.size()>0)
        {
            if(max==-1)
            {
                if(l.get(0)==l.get(l.size()-1))
                {
                    if(l.get(0)==0)
                    {
                        return "0";
                    }
                    else
                    {
                       return num;
                    }
                }
            }
            else
            {
                 if((l.get(0)==l.get(l.size()-1)) && max==l.get(0))
                 {
                     if(l.get(0)==0)
                     {
                         return "0";
                     }
                     else
                     {
                         return num;
                     }
                 }
            }
        }
         String result="";
        if(max>-1)
        {
            
            if(l.size()>0 && l.get(0)==0)
            {
                 result+=Integer.toString(max);
            }
            else
            {
               for(int i=0;i<l.size();i++)
               {
                   result+=Integer.toString(l.get(i));
               }
                result+=Integer.toString(max);
                for(int i=l.size()-1;i>=0;i--)
               {
                   result+=Integer.toString(l.get(i));
               }
            }
        }
        else
        {
            if(l.get(0)==0)
            {
                 return "0";
            }
            for(int i=0;i<l.size();i++)
           {
               result+=Integer.toString(l.get(i));
           }
             for(int i=l.size()-1;i>=0;i--)
           {
               result+=Integer.toString(l.get(i));
           }
            
        }
        return result;
        
        
    }
}
