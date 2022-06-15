class Solution {
    public int numOfSubarrays(int[] arr) {
     int a[]=new int[arr.length];
     int j=0;
     int sum=0;
     for(int i=arr.length-1;i>=0;i--)
     {
         if(arr[i]%2!=0)
         {
             a[i]=1;
             if(i!=arr.length-1)
             {
                 if(a[i]%2==0)
                 {
                     a[i]+=a[i+1];
                 }
                 else
                 {
                     a[i]+=j-a[i+1];
                 }
             }
         }
         else
         {
                if(i!=arr.length-1)
                {
                  a[i]=a[i+1];
                }
         }
         
         sum+=a[i];
         sum=sum%1000000007;
         j++;
     }
        
        return sum;
    }
}
