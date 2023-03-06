class Solution {
    public long coloredCells(int n) {
        long result=1;
        if(n==1)
        {
            return result;
        }
        for(int i=1;i<n;i++)
        {
            result=result+4*(i);
        }
        
        return result;

    }
}
