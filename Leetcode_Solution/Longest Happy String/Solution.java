class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int flag=0;
        int x=0,y=0,z=0;
        String str="";
        while(flag==0)
        {
            if(a==0 && b==0 && c==0)
            {
                break;
            }
            if(a>=b && a>=c)
            {
                y=0;
                z=0;
                if(x<2)
                {
                    str=str+"a";
                    a--;
                    x++;
                }
                else
                {
                    x=0;
                    if(b==0 && c==0)
                    {
                        break;
                    }
                    if(b>c)
                    {
                        str=str+"b";
                        b--;
                    }
                    else
                    {
                        str=str+"c";
                        c--;
                    }
                }
            }
            else if(b>=a && b>=c)
            {
                x=0;
                z=0;
                if(y<2)
                {
                    str=str+"b";
                    b--;
                    y++;
                    
                }
                else
                {
                    y=0;
                    if(a==0 && c==0)
                    {
                        break;
                    }
                    else
                    {
                        if(a>c)
                        {
                            str=str+"a";
                            a--;
                        }
                        else
                        {
                            str=str+"c";
                            c--;
                        }
                    }
                }
            }
            else
            {
                x=0;
                y=0;
                if(z<2)
                {
                    str=str+"c";
                    z++;
                    c--;
                }
                else
                {
                    z=0;
                    if(a==0 && b==0)
                    {
                        break;
                    }
                    else
                    {
                        if(a>b)
                        {
                            str=str+"a";
                            a--;
                        }
                        else
                        {
                            str=str+"b";
                            b--;
                        }
                    }
                }
            }
        }
        return str;
    }
}
