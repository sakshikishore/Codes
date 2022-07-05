class Solution {
    public int countHomogenous(String s) {
        long count=0,p=1;
        for(int i=1;i<s.length();i++)
        {
           if(s.charAt(i)==s.charAt(i-1))
           {
               p++;
           }
           else
           {
               count+=((p*(p+1))/2);
               count=count%(1000000007);
               p=1;
           }
        }
        
         count+=((p*(p+1))/2);
         count=count%(1000000007);
        return (int)count;
    }
}
