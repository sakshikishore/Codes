class Solution {
    public String reorganizeString(String s) {
        int ch[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        int curr=-1;
        String str="";
        char c='a';
        int p=0;
        for(int i=0;i<s.length();i++)
        {
            int max=0;
            int flag=0;
            for(int j=0;j<26;j++)
            {
                if(ch[j]>max && j!=curr)
                {
                    flag=1;
                    c=(char)(97+j);
                    p=j;
                    max=ch[j];
                }
            }
            if(flag==0)
            {
                break;
            }
            str=str+Character.toString(c);
            ch[p]--;
            curr=p;

        }
        if(str.length()!=s.length())
        {
            str="";
        }
        
        return str;
    }
}
