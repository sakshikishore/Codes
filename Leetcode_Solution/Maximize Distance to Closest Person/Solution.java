class Solution {
    public int maxDistToClosest(int[] seats) {
      int left[]=new int[seats.length];
      int right[]=new int[seats.length];
        int l=-1,r=-1;
      for(int i=0;i<seats.length;i++)
      {
          if(seats[i]==1)
          {
              l=i;
              left[i]=-1;
          }
          else
          {
              left[i]=l;
          }
      }
      for(int i=seats.length-1;i>=0;i--)
      {
          if(seats[i]==1)
          {
              r=i;
              right[i]=-1;
          }
          else
          {
              right[i]=r;
          }
      }
        int max=0;
        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]!=1)
            {
               if(left[i]==-1)
               {
                   int x=right[i]-i;
                   if(x>max)
                   {
                       max=x;
                   }
               }
               else if(right[i]==-1)
               {
                   int x=i-left[i];
                   if(x>max)
                   {
                       max=x;
                   }
               }
               else
               {
                   int x=right[i]-i;
                   int y=i-left[i];
                   int p=Math.min(x,y);
                   if(p>max)
                   {
                       max=p;
                   }
               }
            }
        }
        
        return max;
        
    }
}
