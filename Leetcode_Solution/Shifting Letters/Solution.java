class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long total=0;
        char c[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            total+=shifts[i];
        }
        for(int i=0;i<s.length();i++)
        {
            long x=s.charAt(i)-'a';
            x=(x+total)%26;
            c[i]=(char)(97+x);
            total-=shifts[i];
        }
        
        return new String(c);
    }
}
