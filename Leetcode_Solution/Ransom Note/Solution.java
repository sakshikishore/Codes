class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean result=true;
        int mag[]=new int[26];
        int ran[]=new int[26];
        for(int i=0;i<magazine.length();i++)
        {
            mag[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            ran[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(mag[i]<ran[i])
            {
                result=false;
                break;
            }
        }
        
        return result;
    }
}
