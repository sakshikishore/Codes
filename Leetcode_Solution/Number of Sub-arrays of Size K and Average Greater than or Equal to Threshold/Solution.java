class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum=sum+arr[i];
            
        }
        if((sum/k)>=threshold)
        {
            count++;
        }
        int p=0;
        for(int i=k;i<arr.length;i++)
        {
            sum=sum-arr[p]+arr[i];
            if((sum/k)>=threshold)
            {
                count++;
            }
            p++;
            
        }
        
        return count;
        
    }
}
