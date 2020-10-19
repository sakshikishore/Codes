class Solution {
    public boolean validMountainArray(int[] A) {
        boolean result=false;
        int index=0;
        int count=0;
        int l=0;
        if(A.length>2)
        {
            for(int i=1;i<A.length;i++)
            {
                if(A[i]<A[i-1])
                {
                    if(index==0)
                    {
                     index=i;
                    }
                }
                else if(A[i]==A[i-1])
                {
                    count++;
                    break;
                }
                else
                {
                    l++;
                    if(index!=0)
                    {
                        count++;
                        break;
                    }
                }
            }
        }
        
        if(count==0 && A.length>2 && index!=0 && l>0)
        {
            result=true;
        }
        
        return result;
        
    }
}
