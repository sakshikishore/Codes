class Solution {
    public int minSteps(String s, String t) {
        int chs[]=new int[26];
        int cht[]=new int[26];
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            chs[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++)
        {
            cht[t.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++)
        {
            result+=Math.abs(chs[i]-cht[i]);
        }
        
        return result;
    }
}
