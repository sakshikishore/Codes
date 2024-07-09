class Solution {
    public int[] constructArray(int n, int k) {
        int result[]=new int[n];
        result[0]=1;
        if(n==1)
        {
            return result;
        }
        else
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(1);
            int p=k;
            for(int i=2;i<=k+1;i++)
            {
               int x=p+result[i-2];
               if(x<=k+1 && !hset.contains(x))
               {
                    hset.add(x);
                    result[i-1]=x;
               }
               else
               {
                    x=result[i-2]-p;
                    hset.add(x);
                    result[i-1]=x;
               }
               p--;
            }
            for(int i=k+2;i<=n;i++)
            {
                result[i-1]=i;
            }
        }

       
    return result;
    }
}
