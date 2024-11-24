class Solution {
    public boolean canAliceWin(int n) {
    int t=10;
    int flag=0;
        while(n>0)
        {
          if(n<t)
          {
              if(flag==0)
              {
                  return false;
              }
              else
              {
                  return true;
              }
          }
          else
          {
              n=n-t;
              t=t-1;
              flag=flag^1;
          }
        }

        if(flag==0)
        {
            return false;
        }

        return true;
    }
}
