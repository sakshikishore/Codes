class RLEIterator {
    int arr1[];
    int arr2[];
    public RLEIterator(int[] encoding) {
        arr1=new int[encoding.length/2];
        arr2=new int[encoding.length/2];
        int count=0;
        for(int i=0;i<encoding.length;i=i+2)
        {
            arr1[count]=encoding[i];
            arr2[count]=encoding[i+1];
            count++;
        }
    }
    
    public int next(int n) {
        int result=-1;
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]<n)
            {
               n=n-arr1[i];
               arr1[i]=0;
            }
            else
            {
               arr1[i]=arr1[i]-n;
               result=arr2[i];
                break;
                
            }
        }
        
        return result;
    }
}
