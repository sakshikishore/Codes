class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // Case 2 Even is greater than Odd
        int start=0,max=0;
        for(int i=0;i<arr.length;i=i+2)
        {
           if(i==0)
           {
               if(1<arr.length)
               {
                   if(arr[1]>=arr[0])
                   {
                       max=1;
                       start=1;
                   }
               }
           }
           else
           {
                 if(arr[i]>arr[i-1])
                 {
                     if(i+1<arr.length)
                     {
                         if(arr[i+1]>=arr[i])
                         {
                             int r=i-start+1;
                             if(r>max)
                             {
                                 max=r;
                             }
                             start=i+1;
                         }
                     }
                 }
                 else
                 {
                            int r=i-start;
                             if(r>max)
                             {
                                 max=r;
                             }
                              if(i+1<arr.length)
                             {
                                 if(arr[i+1]<arr[i])
                                 {
                                     start=i;
                                 }
                                 else
                                 {
                                     start=i+1;
                                 }
                             }
                             else
                             {
                             start=i;
                             }
                 }
           }
        }

        if(arr.length-start>max)
        {
            max=arr.length-start;
        }
        // Case 1 Odd is greater than Even
        start=0;
        for(int i=1;i<arr.length;i=i+2)
        {
           if(arr[i]>arr[i-1])
           {
              if(i+1<arr.length)
              {
                  if(arr[i]<=arr[i+1])
                  {
                             int r=i-start+1;
                             if(r>max)
                             {
                                 System.out.println(arr[i]+" "+arr[i+1]+" "+start);
                                 max=r;
                                  System.out.println("here");
                             }
                             start=i+1;
                  }
              }
           }
           else
           {
                            int r=i-start;
                             if(r>max)
                             {
                                 max=r;
                             }
                             if(i+1<arr.length)
                             {
                                 if(arr[i+1]<arr[i])
                                 {
                                     start=i;
                                 }
                                 else
                                 {
                                     start=i+1;
                                 }
                             }
                             else
                             {
                             start=i;
                             }
           }
        }

        if(arr.length-start>max)
        {
            max=arr.length-start;
        }

        return max;
    }
}
