class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            int count=1;
            int l=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                l=l+arr[j];
                count++;
                if(count%2!=0)
                {
                    sum=sum+l;
                }
            }
        }
        
        return sum;
        
    }
}
