class Solution {
    public int getKth(int lo, int hi, int k) {
        int arr[]=new int[hi-lo+1];
        int p[]=new int[hi-lo+1];
        for(int i=0;i<hi-lo+1;i++)
        {
            p[i]=lo+i;
            
        }
        int j=0;
        for(int i=lo;i<=hi;i++)
        {
            int q=i;
            while(q!=1)
            {
                if(q%2==0)
                {
                    q=q/2;
                    arr[j]++;
                }
                else
                {
                    q=(3*q)+1;
                    arr[j]++;
                }
            }
            
          
            
            j++;
            
            
        }
        
        for(int i=0;i<arr.length;i++)
        {
            for(int r=i+1;r<arr.length;r++)
            {
              if(arr[i]>arr[r])
              {
                  int temp=arr[i];
                  arr[i]=arr[r];
                  arr[r]=temp;
                  
                  
                  int t=p[i];
                  p[i]=p[r];
                  p[r]=t;
              }
                
            if(arr[i]==arr[r])
            {
                if(p[i]>p[r])
                {
                  int temp=arr[i];
                  arr[i]=arr[r];
                  arr[r]=temp;
                  
                  
                  int t=p[i];
                  p[i]=p[r];
                  p[r]=t;
                }
            }
              
            }
        }
        
        return p[k-1];
    }
    
    
}
