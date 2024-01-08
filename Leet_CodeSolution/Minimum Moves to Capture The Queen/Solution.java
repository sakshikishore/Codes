class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int tempc=c,tempd=d;
        int count=0;
        int flag=0;
        int result=0;
        if(e<=c && f<=d)
        {
                    while(c>0 && d>0)
                    {
                        if(c==e && d==f)
                        {
                            count++;
                            flag=1;
                            break;
                        }
                        else if(c==a && d==b)
                        {
                            count++;
                        }
                        c--;
                        d--;
                    }
                if(flag==1)
                {
                    result=count;
                    if(result==1)
                    {
                        return 1;
                    }
                }
        }
        else if(e<=c && f>d)
        {
            while(c>0 && d<=8)
                    {
                        if(c==e && d==f)
                        {
                            count++;
                            flag=1;
                            break;
                        }
                        else if(c==a && d==b)
                        {
                            count++;
                        }
                        c--;
                        d++;
                    }
                if(flag==1)
                {
                    result=count;
                    if(result==1)
                    {
                        return 1;
                    }
                }
        }
         else if(e>c && f>d)
        {
            while(c<=8 && d<=8)
                    {
                        if(c==e && d==f)
                        {
                            count++;
                            flag=1;
                            break;
                        }
                        else if(c==a && d==b)
                        {
                            count++;
                        }
                        c++;
                        d++;
                    }
                if(flag==1)
                {
                    result=count;
                    if(result==1)
                    {
                        return 1;
                    }
                }
        }
        else if(e>c && f<=d)
        {
            
            while(c<=8 && d>0)
                    {
                        if(c==e && d==f)
                        {
                            count++;
                            flag=1;
                            break;
                        }
                        else if(c==a && d==b)
                        {
                            count++;
                        }
                        c++;
                        d--;
                    }
                if(flag==1)
                {
                    result=count;
                    if(result==1)
                    {
                        return 1;
                    }
                }
        }
        c=tempc;
        d=tempd;
       if(a==e)
       {
           
           if(c==e && d<f &&  d>b)
           {
               
               return 2;
           }
           else if(c==e && d>f && d<b)
           {
               return 2;
           }
           else if(c!=e)
           {
               return 1;
           }
           else if(c==e)
           {
               return 1;
           }
       }
       else if(b==f)
       {
           if(d==f && a<c && e>c)
           {
               return 2;
           }
           else if(d==f && a>c && e<c)
           {
               return 2;
           }
           else if(d==f)
           {
               return 1;
           }
           else if(d!=f)
           {
               return 1;
           }
       }
        
        
        return 2;
        
    }
}
