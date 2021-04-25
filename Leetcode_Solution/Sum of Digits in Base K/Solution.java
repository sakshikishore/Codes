class Solution {
    public int sumBase(int n, int k) {
        int result=0;
        while(n!=0)
        {
            result=result+n%k;
            n=n/k;
        }
        
        return result;
        
    }
}
