class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length>1)
        {
        int p[]=new int[arr.length-1];
        int max=arr[arr.length-1];
        p[arr.length-2]=max;
        for(int i=arr.length-3;i>=0;i--)
        {
            if(arr[i+1]>max)
            {
                max=arr[i+1];
                
            }
            
            p[i]=max;
            
       
           
        }
        
        for(int i=0;i<arr.length-1;i++)
        {
            arr[i]=p[i];
        }
        }
        arr[arr.length-1]=-1;
        return arr;
        
    }
}
