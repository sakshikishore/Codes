class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        boolean result=false;
        int arr[]=new int[derived.length];
        // arr[0]=1
        arr[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=arr[i-1]^derived[i-1];
        }
        if((derived[derived.length-1]^arr[arr.length-1])==arr[0])
        {
            return true;
        }
        if(!result)
        {
            arr=new int[derived.length];
            //arr[0]=0;
            for(int i=1;i<arr.length;i++)
            {
                arr[i]=arr[i-1]^derived[i-1];
            }
            if((derived[derived.length-1]^arr[arr.length-1])==arr[0])
            {
                return true;
            }
        }
        
        return false;
    }
}
