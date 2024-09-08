class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        long ans=0;
        long low=Integer.MAX_VALUE,high=start[start.length-1]+d-start[0];
        for(int j=1;j<start.length;j++)
        {
            if(start[j]-start[j-1]<low)
            {
                low=start[j]-start[j-1];
            }
        }
      
        while(low<=high)
        {
             
            long mid=(low+high)/2;
            long prev=start[0];
            int flag=0;
            for(int i=1;i<start.length;i++)
            {
               long p=mid-(start[i]-prev);
               if(p>d)
               {
                 flag=1;
                 break;
               }
               else
               {
                if(p>=0)
                {
                  prev=start[i]+p;
                }
                else
                {
                    prev=start[i];
                }
               }
            }
            if(flag==0)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
            
        }

        return (int)ans;
    }
}
