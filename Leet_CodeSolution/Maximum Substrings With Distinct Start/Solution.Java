class Solution {
    public int maxDistinct(String s) {
        int ch[]=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']=1;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]==1)
            {
                count++;
            }
        }

        return count;
    }
}
