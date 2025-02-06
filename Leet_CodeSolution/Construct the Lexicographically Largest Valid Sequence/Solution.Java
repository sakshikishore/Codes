class Solution {
    boolean result=false;
    int p[];
    public void Solve(int a[],int n, int arr[])
    {
        if(result)
        {
            return;
        }
        int flag=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
          
            for(int i=0;i<a.length;i++)
            {
                p[i]=a[i];
            }
            result=true;
            return;
        }
        for(int i=n;i>=1;i--)
        {
            if(arr[i]==0)
            {
                for(int j=0;j<a.length;j++)
                {
                    if(a[j]==0)
                    {
                        if(i==1)
                        {
                            a[j]=1;
                            arr[i]=1;
                            Solve(a,n,arr);
                            arr[i]=0;
                            a[j]=0;
                        }
                        else
                        {
                            if(j+i<a.length && a[j+i]==0)
                            {
                                a[j]=i;
                                a[j+i]=i;
                                arr[i]=1;
                                Solve(a,n,arr);
                                arr[i]=0;
                                a[j]=0;
                                a[j+i]=0;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    public int[] constructDistancedSequence(int n) {
        int result[]=new int[(2*n)-1];
        p=new int[(2*n)-1];
        int arr[]=new int[n+1];
        Solve(result,n,arr);

        return p;
    }
}
