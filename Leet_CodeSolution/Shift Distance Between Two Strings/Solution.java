class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] prevCost) {
        long result=0;
        for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!=t.charAt(i))
                {
                   int x=s.charAt(i)-'a';
                   int y=t.charAt(i)-'a';
                    long p=0,q=0;
                   if(s.charAt(i)<t.charAt(i))
                   {
                        for(int j=x;j<y;j++)
                           {
                             p=p+nextCost[j];  
                           }

                       for(int j=x;j>=0;j--)
                           {
                               q+=prevCost[j];
                           }
                          for(int j=y+1;j<26;j++)
                              {
                                  q+=prevCost[j];
                              }

                       result+=(long)Math.min(p,q);
                   }
                else
                   {
                     for(int j=x;j<26;j++)
                         {
                             p+=nextCost[j];
                         }
                        for(int j=0;j<y;j++)
                            {
                                p+=nextCost[j];
                            }

                       for(int j=x;j>y;j--)
                           {
                               q+=prevCost[j];
                           }

                       result+=(long)Math.min(p,q);
                   }
                }
            }

        return result;
    }
}
