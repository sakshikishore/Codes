class Solution {
    public int xorOperation(int n, int start) {
        int p=start;
        for(int i=1;i<n;i++)
        {
            p=p^(start+(2*i));
        }
        
        return p;
        
    }
}
