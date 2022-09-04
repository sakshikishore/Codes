class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++)
        {
            String s=Integer.toString(n,i);
            StringBuffer sb=new StringBuffer(s);
            String str=new String(sb.reverse());
            if(!str.equals(s))
            {
                return false;
            }
        }
        
        return true;
    }
}
