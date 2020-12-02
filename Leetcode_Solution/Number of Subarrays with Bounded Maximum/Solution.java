class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            int max=A[i];
            if(max>=L && max<=R)
            {
                count++;
            }
            for(int j=i+1;j<A.length;j++)
            {
                if(max<A[j])
                {
                    max=A[j];
                    if(max>R)
                    {
                        break;
                    }
                    else
                    {
                         if(max>=L && max<=R)
                            {
                                count++;
                            }
                    }
                }
                else
                {
                     if(max>=L && max<=R)
                     {
                          count++;
                     }
                }
            }
        }
        
        return count;
        
    }
}
