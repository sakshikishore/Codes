class Solution {
    public String restoreString(String s, int[] indices) {
        char c[]=s.toCharArray();
        char p[]=new char[c.length];
        for(int i=0;i<s.length();i++)
        {
            p[indices[i]]=c[i];
        }
        
        return new String(p);
    }
}
