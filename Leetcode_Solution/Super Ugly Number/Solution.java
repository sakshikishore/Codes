class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[]=new int[n];
        dp[0]=1;
        int arr[]=new int[primes.length];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<primes.length;i++)
        {
            map.put(primes[i],i);
        }
        for(int i=1;i<n;i++)
        {
            int min=Integer.MAX_VALUE;
            HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
            for(int j=0;j<primes.length;j++)
            {
                long y=1;
                y=y*dp[arr[j]]*primes[j];
                int x=dp[arr[j]]*primes[j];
                if(y<=min)
                {
                    min=x;
                    if(!h.containsKey(x))
                    {
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(primes[j]);
                        h.put(x,l);
                    }
                    else
                    {
                        ArrayList<Integer> l=h.get(x);
                        l.add(primes[j]);
                        h.put(x,l);
                    }
                } 
            }
            dp[i]=min;
            ArrayList<Integer> l=h.get(min);
            for(int k=0;k<l.size();k++)
            {
                int val=l.get(k);
                int a=map.get(val);
                arr[a]++;
            }
        }
        return dp[n-1];
    }
}
