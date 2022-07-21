class Solution {
    public int getWinner(int[] arr, int k) {
        int max=0;
        int result=0;
        int count=0,res=0;
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]>max)
           {
               max=arr[i];
           }
       }
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]==max || arr[i+1]==max)
           {
               result=max;
               break;
           }
           else
           {
               if(arr[i]>arr[i+1])
               {
                   int temp=arr[i];
                   arr[i]=arr[i+1];
                   arr[i+1]=temp;
                   if(count==0)
                   {
                       count++;
                       result=arr[i+1];
                       if(count==k)
                       {
                           break;
                       }
                   }
                   else
                   {
                       
                       if(arr[i+1]==result)
                       {
                           count++;
                           if(count==k)
                           {
                               break;
                           }
                       }
                       else
                       {
                           count=1;
                           result=arr[i+1];
                       }
                   }
               }
               else
               {
                   count=1;
                   result=arr[i+1];
                   if(count==k)
                   {
                       break;
                   }
               }
           }
       }
        
        return result;
    }
}
