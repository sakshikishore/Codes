class Solution {
    public int countHousePlacements(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<=n;i++)
        {
            arr[i]=(arr[i-1]+arr[i-2])%(1000000007);
        }
        long result=1L;
        result=result*arr[n]*arr[n];
        result=result%1000000007;
        return (int)result;
    }
}
