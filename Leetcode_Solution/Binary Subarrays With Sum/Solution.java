class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            int sum=A[i];
            boolean flag=false;
            if(sum==S)
            {
                count++;
                flag=true;
            }
            for(int j=i+1;j<A.length;j++)
            {
                if(flag==true)
                {
                  if(A[j]==1)
                  {
                      break;
                  }
                  else
                  {
                      count++;
                  }
                }
                else
                {
                    sum=sum+A[j];
                    if(sum==S)
                    {
                        count++;
                        flag=true;
                    }
                }
            }
        }
        
        return count;
    }
    
}
