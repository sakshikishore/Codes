class Solution {
    public int minFlips(String target) {    
      int count=0;
      char p='0';
      for(int i=0;i<target.length();i++)
      {
          if(i==0)
          {
              if(target.charAt(i)!=p)
              {
                  count++;
                  p='1';
              }
          }
          else
          {
              if(target.charAt(i)!=p)
              {
                  count++;
                   if(p=='0')
                      {
                          p='1';
                      }
                      else
                      {
                          p='0';
                      }
              }
          }
                                
        }
        
        return count;
    }
}
