class Solution {
    public int sumSubarrayMins(int[] arr) {
        long result=0;
        for(int i=0;i<arr.length;i++)
        {
            int min=arr[i];
            result+=min;
            for(int j=i+1;j<arr.length;j++)
            {
                 if(arr[j]<min)
                 {
                     min=arr[j];
                 }
                 result+=min;
            }

            result=result%1000000007;

        }

        return (int)result%1000000007;
    }
}
