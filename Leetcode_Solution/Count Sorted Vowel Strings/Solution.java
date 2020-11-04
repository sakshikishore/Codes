class Solution {
    public int countVowelStrings(int n) {
        int result=0;
        int a[]={1,1,1,1,1};
      for(int i=2;i<=n;i++)
      {
          for(int j=3;j>=0;j--)
          {
              a[j]=a[j]+a[j+1];
          }
      }
        for(int i=0;i<5;i++)
        {
            result=result+a[i];
        }
        return result;
    }
}
