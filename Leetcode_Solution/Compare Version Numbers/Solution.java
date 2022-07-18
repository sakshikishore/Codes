class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int i=0,j=0,flag=0;
        int ans=0;
        while(i<v1.length && j<v2.length)
        {
            int x=Integer.parseInt(v1[i]);
            int y=Integer.parseInt(v2[i]);
            if(x>y)
            {
                flag=1;
                ans=1;
                break;
            }
            if(x<y)
            {
                flag=1;
                ans=-1;
                break;
            }
            i++;
            j++;
            
        }
        if(flag==0)
        {
            if(i<v1.length)
            {
               for(int p=i;p<v1.length;p++)
               {
                   int x=Integer.parseInt(v1[p]);
                   if(x>0)
                   {
                       ans=1;
                       break;
                   }
               }
            }
            else if(j<v2.length)
            {
               for(int p=j;p<v2.length;p++)
               {
                   int x=Integer.parseInt(v2[p]);
                   if(x>0)
                   {
                       ans=-1;
                       break;
                   }
               }
            }
        }
        return ans;
    }
}
