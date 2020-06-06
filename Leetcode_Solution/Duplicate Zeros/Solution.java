class Solution {
    public void duplicateZeros(int[] arr) {
        int a[]=new int[arr.length];
        int j=0;
        int i=0;
        while(j<arr.length)
        {
            if(arr[i]==0)
            {
                a[j]=0;
                if(j+1<arr.length)
                {
                a[j+1]=0;
                }
                j=j+2;
                i++;
                
            }
            else
            {
                a[j]=arr[i];
                i++;
                j++;
            }
        }
        for(int l=0;l<arr.length;l++)
        {
            arr[l]=a[l];
        }
       
    }
}
