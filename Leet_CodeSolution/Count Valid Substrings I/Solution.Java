class Solution {
    public long countValidSubstrings(String s) {
        int prev=-1;
        long p=0;
        for(int i=2;i<s.length();i++)
        {
            if(s.charAt(i-2)=='a' && s.charAt(i-1)=='b' && s.charAt(i)=='c')
            {
                if(prev==-1)
                {
                    prev=i-1;
                    long x=i-1;
                    long y=s.length()-i;
                    p+=(x*y);
                }
                else
                {
                     long x=i-1-prev;
                    long y=s.length()-i;
                    p+=(x*y);
                    prev=i-1;
                }
            }
        }
      long ans=(s.length()*1l*(s.length()+1))/2;
      return ans-p;
    }
}
