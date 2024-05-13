class Solution {
    public int findPermutationDifference(String s, String t) {
        int ch[]=new int[26];
        Arrays.fill(ch,-1);
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']=i;
        }
        int result=0;
        for(int i=0;i<t.length();i++)
        {
            result+=Math.abs(i-ch[t.charAt(i)-'a']);
        }
        
        return result;
    }
}
