class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ch[]=new int[26];
        int result=0;
        for(int i=0;i<allowed.length();i++)
        {
            ch[allowed.charAt(i)-'a']++;
        }
        for(int i=0;i<words.length;i++)
        {
            int flag=1;
            for(int j=0;j<words[i].length();j++)
            {
                if(ch[words[i].charAt(j)-'a']!=1)
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                result++;
            }
        }
        
        return result;
    }
}
