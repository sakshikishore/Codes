class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        boolean result=true;
        for(int i=0;i<target.length;i++)
        {
            if(arr[i]!=target[i])
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
