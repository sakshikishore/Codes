class Solution {
    public boolean isFascinating(int n) {
        int arr[]=new int[10];
        int p=n*2;
        int q=n*3;
        while(n!=0)
        {
            int r=n%10;
            arr[r]++;
            if(arr[r]>1 || r==0)
            {
                return false;
            }
            n=n/10;
        }
        while(p!=0)
        {
            int r=p%10;
            arr[r]++;
            if(arr[r]>1 || r==0)
            {
                return false;
            }
            p=p/10;
        }
        while(q!=0)
        {
            int r=q%10;
            arr[r]++;
            if(arr[r]>1 || r==0)
            {
                return false;
            }
            q=q/10;
        }
        for(int i=1;i<=9;i++)
        {
            if(arr[i]==0)
            {
                return false;
            }
        }
        return true;
        
    }
}
