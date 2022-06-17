class Solution {
    public int numTimesAllBlue(int[] flips) {
        int arr1[]=new int[flips.length];
        int arr2[]=new int[flips.length];
        int count=0;
        for(int i=0;i<flips.length;i++)
        {
            arr1[i]=i+1;
            arr2[flips[i]-1]=flips[i];
            if(Arrays.equals(arr1,arr2))
            {
                count++;
            }
        }
        
        return count;
    }
    
}
