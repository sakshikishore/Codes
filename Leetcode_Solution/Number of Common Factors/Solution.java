class Solution {
    public int commonFactors(int a, int b) {
        int x=Math.min(a,b);
        int result=1;
        for(int i=2;i<=x;i++)
        {
            if(a%i==0 && b%i==0)
            {
                result++;
            }
        }
        
        return result;
    }
}
