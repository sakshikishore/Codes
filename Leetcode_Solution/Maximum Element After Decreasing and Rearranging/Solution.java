class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max=1;
        for(int i=0;i<arr.length;i++)
        {
            if(i==0)
            {
                if(arr[0]!=1)
                {
                    arr[0]=1;
                    
                }
                    
            }
            else
            {
                if(Math.abs(arr[i]-arr[i-1])>1)
                {
                    arr[i]=arr[i-1]+1;
                    
                }
                if(max<arr[i])
                {
                   max=arr[i];
                }
            }
            
        }
        
        return max;
        
    }
}
