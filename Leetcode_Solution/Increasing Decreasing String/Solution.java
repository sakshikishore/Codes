class Solution {
    public String sortString(String s) {
        char c[]=s.toCharArray();
        Arrays.sort(c);
        String p="";
        int k=0;
        while(p.length()!=c.length)
        {
            int count=0;
            char prev='a';
            if(k%2==0)
            {
                
                for(int i=0;i<c.length;i++)
                {
                    if(count==0)
                    {
                        if(c[i]!='1')
                        {
                            p=p+Character.toString(c[i]);
                            prev=c[i];
                            c[i]='1';
                            count++;
                        }
                    }
                    else
                    {
                        if(c[i]!='1' && c[i]!=prev)
                        {
                            p=p+Character.toString(c[i]);
                            prev=c[i];
                            c[i]='1';
                            
                        }
                    }
                }
            }
            else
            {
                for(int i=c.length-1;i>=0;i--)
                {
                    if(count==0)
                    {
                        if(c[i]!='1')
                        {
                            p=p+Character.toString(c[i]);
                            prev=c[i];
                            c[i]='1';
                            count++;
                        }
                    }
                    else
                    {
                        if(c[i]!='1' && c[i]!=prev)
                        {
                            p=p+Character.toString(c[i]);
                            prev=c[i];
                            c[i]='1';
                            
                        }
                    }
                }
            }
            k++;
        }
        
        return p;
        
    }
}
