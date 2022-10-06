class Solution {
    int count=0;
    public void permutation(int arr[], int index)
    {
        if(index==arr.length)
        {
           count++;
        }
        for(int i=index;i<arr.length;i++)
        {
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
            if(arr[index]%(index+1)==0 || (index+1)%arr[index]==0)
            {
             permutation(arr,index+1);
            }
            temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
    }
    public int countArrangement(int n) {
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
        }
        permutation(arr,0);
        return count;
    }
    
    
}
