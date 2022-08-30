class Solution {
    public int nthUglyNumber(int n) {
        int arr[]=new int[n];
        arr[0]=1;
        int two=0,three=0,five=0;
        for(int i=1;i<n;i++)
        {
           int x=arr[two]*2;
           int y=arr[three]*3;
           int z=arr[five]*5;
           if(x<y && x<z)
           {
               arr[i]=x;
               two++;
           }
           else if(y<z && y<x)
           {
               arr[i]=y;
               three++;
           }
           else if(z<x && z<y)
           {
               arr[i]=z;
               five++;
           }
           else if(x==y && z==x)
           {
               arr[i]=x;
               two++;
               three++;
               five++;
           }
           else if(x==y && x<z)
           {
               
               arr[i]=x;
               two++;
               three++;
           }
           else if(x==z && x<y)
           {
               arr[i]=x;
               two++;
               five++;
           }
           else if(y==z && y<x)
           {
              arr[i]=y;
               three++;
               five++;
           }
         
        }
        
        return arr[n-1];
        
    }
}
