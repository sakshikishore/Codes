class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max=0,a=0,b=0;
        for(int i=0;i<A.length-1;i++)
        {
            if(i==0)
            {
                int sum=A[i]+A[i+1]-1;
                if(A[i]-A[i+1]>1)
                {
                    b=A[i];
                    a=i;
                }
                else
                {
                    b=A[i+1];
                    a=i+1;
                }
                if(max<sum)
                {
                   max=sum;
                }
            }
            else
            {                
                 int sum=b+A[i+1]+a-(i+1);
                 if(b-A[i+1]<=(i+1-a))
                 {
                     b=A[i+1];
                     a=i+1;
                 }
                if(max<sum)
                {
                    max=sum;
                }
            }
        }
        
        return max;
    }
}
