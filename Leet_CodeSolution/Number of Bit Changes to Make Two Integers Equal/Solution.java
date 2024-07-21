class Solution {
    public int minChanges(int n, int k) {
        int p=(n & k);
        if(p==k)
        {
            int x=Integer.bitCount(n);
            int y=Integer.bitCount(k);
            return x-y;
        }
        return -1;
    }
}
