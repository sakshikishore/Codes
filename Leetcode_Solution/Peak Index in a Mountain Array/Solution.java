class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int index=0;
        int max=A[0];
        for(int i=1;i<A.length;i++)
        {
            if(A[i]>max)
            {
                max=A[i];
                index=i;
            }
        }
        
        return index;
        
    }
}
