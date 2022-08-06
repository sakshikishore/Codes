class Solution {
    public String strWithout3a3b(int a, int b) {
      String str="";
        int alen=0,blen=0;
      while(a!=0 && b!=0)
      {
          if(a>b && alen<2)
          {
              blen=0;
              str=str+"a";
              alen++;
              a--;
          }
          else
          {
              alen=0;
              if(blen==2)
              {
                  str=str+"a";
                  alen++;
                  blen=0;
                  a--;
              }
              else
              {
                  str=str+"b";
                  blen++;
                  b--;
                  
              }
          }
      }
        if(a!=0)
        {
            while(a!=0)
            {
                str=str+"a";
                a--;
            }
        }
        else if(b!=0)
        {
            while(b!=0)
            {
                str=str+"b";
                b--;
            }
        }
        
        return str;
    }
}
