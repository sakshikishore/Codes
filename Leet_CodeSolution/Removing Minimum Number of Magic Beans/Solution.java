class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
       long suff[]=new long[beans.length];
       long ans=0;
       for(int i=beans.length-1;i>=0;i--)
       {
          ans+=beans[i];
          suff[i]=ans;
       } 
       ans=Long.MAX_VALUE;
       long val=0;
       long n=beans.length;
       for(int i=0;i<beans.length-1;i++)
       {
           long p=suff[i+1];
           p=val+(p-(beans[i]*(n-(i+1))));
           if(p<ans)
           {
               ans=p;
           }
           val+=beans[i];
       }
       if(val<ans)
       {
          ans=val;
       }

       return ans;
       
    }
}
