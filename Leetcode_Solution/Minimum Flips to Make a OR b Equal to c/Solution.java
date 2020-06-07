class Solution {
    public int minFlips(int a, int b, int c) {
        String p;
        String q;
        String r=Integer.toString(c,2);
        int count=0;
        if(a>b)
        {
            p=Integer.toString(a,2);
            q=Integer.toString(b,2);
        }
        else
        {
            p=Integer.toString(b,2);
            q=Integer.toString(a,2);
        }
        int j=p.length()-1;
        int k=q.length()-1;
       for(int i=r.length()-1;i>=0;i--)
       {
           if(r.charAt(i)=='1')
           {
               if(k>=0)
               {
                   if(q.charAt(k)=='0' && p.charAt(j)=='0')
                   {
                       count++;
                   }
               }
               else
               {
                   if(j>=0)
                   {
                       if(p.charAt(j)=='0')
                       {
                        count++;
                       }
                   }
                   else
                   {
                       count++;
                   }
               }
           }
           else
           {
                if(k>=0)
               {
                   if(q.charAt(k)=='1' && p.charAt(j)=='1')
                   {
                       count=count+2;
                   }
                    else if(q.charAt(k)=='1' || p.charAt(j)=='1')
                    {
                        count++;
                    }
               }
               else
               {
                   if(j>=0)
                   {
                       if(p.charAt(j)=='1')
                       {
                        count++;
                       }
                   }
                  
               }
           }
           k--;
           j--;
       }
        if(p.length()>r.length())
        {
            while(j>=0)
            {
                if(p.charAt(j)=='1')
                {
                    count++;
                }
                j--;

            }
            while(k>=0)
            {
                if(q.charAt(k)=='1')
                {
                    count++;
                }
                
                k--;
            }
            
        }
        
        return count;
}
}
