class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())
        {
            return false;
        }
        int ch[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=t.charAt(i))
            {
                int p=t.charAt(i)-s.charAt(i);
                if(p<0)
                {
                    p=p+26;
                }
                if(ch[p]==0)
                {
                    if(p<=k)
                    {
                       ch[p]=p;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if(ch[p]+26<=k)
                    {
                         ch[p]+=26;
                    }
                    else
                    {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
