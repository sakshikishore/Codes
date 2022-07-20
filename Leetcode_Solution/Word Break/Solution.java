class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int arr[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
                  for(int j=0;j<s.length()-i;j++)
                  {
                      String str=s.substring(j,j+i+1);
                      if(wordDict.contains(str))
                      {
                        arr[j][j+i]=1;
                      }
                      else
                      {
                          for(int k=j;k<j+i;k++)
                          {
                              if(arr[j][k]==1 && arr[k+1][j+i]==1)
                              {
                                  arr[j][j+i]=1;
                                  break;
                              }
                          }
                      }
                  }
      
        }
        
        if(arr[0][s.length()-1]==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
