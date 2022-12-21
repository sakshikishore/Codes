class Solution {
    public int maximumValue(String[] strs) {
        int res=0;
        for(int i=0;i<strs.length;i++)
        {
            int flag=0;
           for(int j=0;j<strs[i].length();j++)
           {
               if(strs[i].charAt(j)>='0' && strs[i].charAt(j)<='9')
               {
                   continue;
               }
               flag=1;
               break;
           }
           if(flag==1)
           {
               if(strs[i].length()>res)
               {
                   res=strs[i].length();
               }
           }
           else
           {
              int x=Integer.parseInt(strs[i]);
              if(x>res)
              {
                  res=x;
              }
           }
        }

        return res;
    }
}
