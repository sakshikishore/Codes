class Solution {
    public int[] decode(int[] encoded) {
        int total=0;
        for(int i=1;i<=encoded.length+1;i++)
        {
            total=total^i;
        }
        int result[]=new int[encoded.length+1];
        int arr[]=new int[encoded.length];
        int p=0;
        for(int i=0;i<encoded.length;i++)
        {
            p=p^encoded[i];
            arr[i]=p;
        }
        
        for(int i=0;i<arr.length;i++)
        {
            result[0]=result[0]^arr[i];
        }
        
        result[0]=result[0]^total;
        for(int i=0;i<encoded.length;i++)
        {
            result[i+1]=result[i]^encoded[i];
        }
        
        return result;
        
    }
}
