class Solution {
    public String smallestSubsequence(String s) {
        int ch[]=new int[26];
        int c[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
            if(i==0)
            {
                 c[s.charAt(i)-'a']++;
            }
        }
        String res=s.substring(0,1);
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        h.put(s.charAt(0),1);
        for(int i=1;i<s.length();i++)
        {
            char a=s.charAt(i);
            char d=res.charAt(res.length()-1);
            if(a==d)
            {
                c[a-'a']++;
                continue;
            }
            else
            {
                if(h.containsKey(a))
                {
                    c[a-'a']++;
                    continue;
                }
                else if(a>d)
                {
                    h.put(a,1);
                    res=res+Character.toString(a);
                    c[a-'a']++;      
                }
                else
                {
                    int flag=0;
                    while(flag!=1)
                    {
                        if(a<d && c[d-'a']<ch[d-'a'])
                        {
                            h.remove(d);
                            res=res.substring(0,res.length()-1);
                            if(res.length()>0)
                            {
                                d=res.charAt(res.length()-1);

                            }
                            else
                            {
                                break;
                            }
                        }
                        else
                        {
                            break;
                        }
                    }
                    res=res+Character.toString(a);
                    c[a-'a']++;      
                    h.put(a,1);
                }
            }
        }
        return res;
    }
}
