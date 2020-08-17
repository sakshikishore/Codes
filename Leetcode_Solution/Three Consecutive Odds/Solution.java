class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean result=false;
        for(int i=0;i<arr.length-2;i++)
        {
            if(arr[i]%2!=0 && arr[i+1]%2!=0 && arr[i+2]%2!=0)
            {
                result=true;
                break;
            }
        }
        
        
        return result;
        
    }
}
