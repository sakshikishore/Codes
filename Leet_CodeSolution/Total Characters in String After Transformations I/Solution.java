class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long ch[]=new long[26];
        long ans=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t;i++)
        {
            long p[]=new long[26];
            for(int j=0;j<25;j++)
            {
                if(ch[j]!=0)
                {
                    p[j+1]=ch[j];
                    p[j+1]= p[j+1]%(1000000007);
                }
            }
            if(ch[25]!=0)
            {
                p[0]+=ch[25];
                p[0]=p[0]%(1000000007);
                p[1]+=ch[25];
                p[1]=p[1]%(1000000007);
            }

            ch=p;
        }

        for(int i=0;i<26;i++)
        {
            ans+=ch[i];

        }

        return (int)(ans%(1000000007));

    }
}
