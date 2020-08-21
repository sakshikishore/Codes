class Solution {
    public int[] sortArrayByParity(int[] A) {
        int k=0;
        int arr[]=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%2==0)
            {
                arr[k]=A[i];
                k++;
            }
        }
         for(int i=0;i<A.length;i++)
        {
            if(A[i]%2!=0)
            {
                arr[k]=A[i];
                k++;
            }
        }
        
        return arr;
    }
}
