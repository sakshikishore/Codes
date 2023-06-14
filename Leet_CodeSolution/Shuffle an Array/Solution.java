class Solution {
  int arr[];
  Random rand = new Random();
    public Solution(int[] nums) {
        arr=nums;
    }
    
    public int[] reset() {
        return arr;
    }
    
    public int[] shuffle() {
        int a[]=new int[arr.length];
        for(int i=0;i<a.length;i++)
        {
            a[i]=arr[i];
        }
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int x=(int)rand.nextInt(n-i);
            int temp=a[n-i-1];
            a[n-i-1]=a[x];
            a[x]=temp;

        }

        return a;
    }
}
