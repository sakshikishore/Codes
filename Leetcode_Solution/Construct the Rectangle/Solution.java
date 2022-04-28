class Solution {
    public int[] constructRectangle(int area) {
     int arr[]=new int[2];
     int mid=area/2;
     int min=area-1;
     arr[0]=area;
     arr[1]=1;
     for(int i=2;i<=mid;i++)
     {
         if(area%i==0)
         {
             int p=i;
             int q=area/i;
            if(i<area/i)
            {
                p=area/i;
                q=i;
            }
            if(p-q<min)
            {
                arr[0]=p;
                arr[1]=q;
                min=arr[0]-arr[1];
            }
         }
     }
        
        return arr;
    }
}
