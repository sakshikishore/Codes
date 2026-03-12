class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min=101;
        int result=-1;
        for(int i=0;i<capacity.length;i++)
        {
            if(capacity[i]>=itemSize && capacity[i]<min)
            {
                result=i;
                min=capacity[i];
            }
        }

        return result;
    }
}
