class Solution {
    public int minOperations(int[][] grid, int x) {
        int c=0;
        int arr[]=new int[grid.length*grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                arr[c]=grid[i][j];
                c++;
            }
        }
        if(arr.length==0)
        {
            return 0;
        }
        Arrays.sort(arr);
        long pref[]=new long[arr.length];
        pref[0]=arr[0]*1l;
        for(int i=1;i<arr.length;i++)
        {
            int p=arr[i]-arr[0];
            if(p%x!=0)
            {
                return -1;
            }
            pref[i]=pref[i-1]+arr[i];
        }
        long result=0;
        for(int i=0;i<arr.length;i++)
        {
                int nextCount=arr.length-1-i;
                int prevCount=i;
                if(i==0)
                {
                    long q=1l;
                    q=(q*nextCount)*arr[i];
                    long sum=pref[pref.length-1]-pref[i];
                    sum=sum-q;
                    result=(sum/x);
                }
                else if(i==pref.length-1)
                {
                    long p=1l;
                    p=(p*prevCount)*arr[i];
                    long sum=pref[i-1];
                    p=p-sum;
                    long res=p/x;
                    result=Math.min(res,result);
                }
                else
                {
                    long q=1l;
                    long res=0;
                    q=(q*nextCount)*arr[i];
                    long sum=pref[pref.length-1]-pref[i];
                    sum=sum-q;
                    res=(sum/x);

                    long p=1l;
                    p=(p*prevCount)*arr[i];
                    sum=pref[i-1];
                    p=p-sum;
                    res=res+(p/x);
                    result=Math.min(res,result);

                }

                
              
        }

        return (int)result;


    }
}
