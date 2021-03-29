class Solution {
    public int reinitializePermutation(int n) {
        int flag=0;
        int count=0;
        int arr[]=new int[n];
        int perm[]=new int[n];
        for(int i=0;i<n;i++)
        {
            perm[i]=i;
        }
        while(flag!=1)
        {
            int l=1;
            for(int i=0;i<n;i++)
            {
                if(i%2==0)
                {
                    arr[i]=perm[i/2];
                }
                else
                {
                    arr[i]=perm[(n/2)+(i-1)/2];
                }
            }
            count++;
            for(int i=0;i<n;i++)
            {
                if(arr[i]!=i)
                {
                    l=0;
                    break;
                }
            }
            if(l==1)
            {
                flag=1;
            }
            else
            {
                for(int i=0;i<n;i++)
                {
                    perm[i]=arr[i];
                }
        }
    }
        return count;
        
}
}
