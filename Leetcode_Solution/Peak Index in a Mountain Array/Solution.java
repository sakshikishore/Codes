class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int index=0;
        for(int i=1;i<A.length;i++)
        {
            if(A[i]<A[i-1])
            {
                index= i-1;
                break;           
            }
        }        
       return index;
        
    }
}
