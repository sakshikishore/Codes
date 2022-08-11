class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int arr[]=new int[10001];
        int val=0,curr=-1;
        for(int i=0;i<barcodes.length;i++)
        {
            arr[barcodes[i]]++;
        }
        int result[]=new int[barcodes.length];
        for(int i=0;i<barcodes.length;i++)
        {
            int max=0;
            for(int j=0;j<10001;j++)
            {
                if(arr[j]>max && j!=curr)
                {
                    max=arr[j];
                    val=j;
                }
            }
            
            result[i]=val;
            arr[val]--;
            curr=val;
            
        }
        
        return result;
    }
}
