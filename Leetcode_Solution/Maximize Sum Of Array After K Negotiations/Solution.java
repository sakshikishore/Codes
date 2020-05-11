class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i=0;
        int sum=0;
        int r=0;
        int count=0;
        for(int l=0;l<K;l++)
        {
            if(A[i]<0 && count==0)
            {
               
                A[i]=A[i]*(-1);
                i++;
            }
            else
            {
                if(i>0 && count==0)
                {
                    if(A[i-1]<A[i])
                    {
                        
                        i--;
                        A[i]=A[i]*-1;
                        r=1;
                    }
                    
                }
                if(r==0)
                {
                     A[i]=A[i]*-1;
                     count++;
                }
                
               
            }
        }
        for(int j=0;j<A.length;j++)
        {
            System.out.println(A[j]);
            sum=sum+A[j];
        }
        return sum;
    }
}
