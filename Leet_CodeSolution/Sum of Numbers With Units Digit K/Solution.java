class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0)
        {
            return 0;
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(num%10==k)
        {
            return 1;
        }
        while(k<=num)
        {
            l.add(k);
            k=k+10;
        }
        int arr[]=new int[num+1];
        int dp[]=new int[num+1];
        dp[0]=1;
        for(int i=0;i<l.size();i++)
        {
            for(int j=l.get(i);j<=num;j++)
            {
                if(dp[j-l.get(i)]>0)
                {
                    dp[j]+=dp[j-l.get(i)];
                    if(j-l.get(i)==0)
                    {
                         arr[j]=1;
                    }
                    else
                    {
                        if(arr[j]==0)
                        {
                            arr[j]=arr[j-l.get(i)]+1;
                        }
                        else if(arr[j-l.get(i)]+1<arr[j])
                        {
                            arr[j]=arr[j-l.get(i)]+1;
                        }
                    }
                }
            }
        }

        if(arr[num]==0)
        {
            return -1;
        }

        return arr[num];

    }

}
