class LUPrefix {
    int arr[];
    int result=0;
    public LUPrefix(int n) {
        arr=new int[n];
    }
    
    public void upload(int video) {
       arr[video-1]=video;
    }
    
    public int longest() {
       int j=result;
       for(int i=j;i<arr.length;i++)
       {
           if(arr[i]!=i+1)
           {
               break;
           }
           else
           {
               result++;
           }
       }
        
        return result;
    }
}
