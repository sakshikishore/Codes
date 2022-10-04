class Solution {
    public int maxDiff(int num) {
        String str=Integer.toString(num);
        char c[]=str.toCharArray();
        // Maximum value;
        char p='a';
        for(int i=0;i<c.length;i++)
        {
            if(c[i]!='9')
            {
                p=c[i];
                break;
            }
        }
        
        if(p!='a')
        {
            for(int i=0;i<c.length;i++)
            {
                if(c[i]==p)
                {
                    c[i]='9';
                }
            }
        }
        
        String s1=new String(c);
        int max=Integer.parseInt(s1);
        
        char ch[]=str.toCharArray();
        //Minimum value;
        
        p='a';
        int flag=0;
        for(int i=1;i<ch.length;i++)
        {
            if(ch[i]!=ch[i-1])
            {
                flag=1;
                break;
            }
        }
        
        if(flag==0)
        {
            for(int i=0;i<ch.length;i++)
            {
                ch[i]='1';
            }
            s1=new String(ch);
            int min=Integer.parseInt(s1);
            return max-min;
        }
        else
        {
            if(ch[0]=='1')
            {
                for(int i=1;i<ch.length;i++)
                {
                    if(ch[i]!='1' && ch[i]!='0')
                    {
                        p=ch[i];
                        break;
                    }
                }
                
                for(int i=1;i<ch.length;i++)
                {
                    if(ch[i]==p)
                    {
                        ch[i]='0';
                    }
                }
                    s1=new String(ch);
                    int min=Integer.parseInt(s1);
                    return max-min;
                
            }
            else
            {
                p=ch[0];
                for(int i=0;i<ch.length;i++)
                {
                    if(ch[i]==p)
                    {
                        ch[i]='1';
                    }
                }
                    s1=new String(ch);
                    int min=Integer.parseInt(s1);
                    return max-min;
            }
        }
        
    }
}
