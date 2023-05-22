class Solution {
    public String makeSmallestPalindrome(String s) {
        int i=0,j=s.length()-1;
        char c[]=new char[s.length()];
        while(i<j)
        {
          if(s.charAt(i)==s.charAt(j))
          {
              c[i]=s.charAt(i);
              c[j]=s.charAt(j);
          }
          else
          {
              if(s.charAt(i)>s.charAt(j))
              {
                  c[i]=s.charAt(j);
                  c[j]=s.charAt(j);
              }
              else
              {
                  c[i]=s.charAt(i);
                  c[j]=s.charAt(i);
              }
          }
          i++;
          j--;
        }
        if(i==j)
        {
            c[i]=s.charAt(i);
        }

        return new String(c);
    }
}
