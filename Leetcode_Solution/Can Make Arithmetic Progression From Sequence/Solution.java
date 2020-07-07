class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        boolean result=true;
        if(arr.length>1)
        {
            Arrays.sort(arr);
            int d=arr[1]-arr[0];
            for(int i=2;i<arr.length;i++)
            {
                if(arr[i]-arr[i-1]!=d)
                {
                   result=false;
                    break;
                }
            }
        }
        
        
        return result;
        
    }
}
