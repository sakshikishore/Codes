class Solution {
    public int maximumScore(int a, int b, int c) {
        int flag=1;
        int arr[]=new int[3];
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        Arrays.sort(arr);
        int count=0;
        while(flag!=0)
        {
            if(arr.length==3)
            {
            int x=arr[2]-arr[1]+1;
            int z=Math.min(arr[0],x);
            arr[0]=arr[0]-z;
            arr[2]=arr[2]-z;
            count+=z;
            }
            else
            {
                int z=Math.min(arr[0],arr[1]);
                count=count+z;
                break;
            }
            if(arr[0]==0 && arr[arr.length-1]==0)
            {
                flag=0;
                break;
            }
            else if(arr[0]==0)
            {
                int a1=arr[1];
                int a2=arr[2];
                arr=new int[2];
                arr[0]=a1;
                arr[1]=a2;
                Arrays.sort(arr);
            }
            else
            {
                Arrays.sort(arr);
            }
                
            
        }
        
        return count;
    }
}
