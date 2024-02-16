class Solution {
    public int minFlipsMonoIncr(String s) {
        int count=1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                l.add(count);
                count=1;
            }
        }
        l.add(count);
         int dp[]=new int[l.size()];
        if(s.charAt(0)=='0')
        {
            int one=0;
            if(l.size()>1)
            {
              one=l.get(1);
            }
           
            for(int i=2;i<l.size();i++)
            {
                if(i%2==0)
                {
                 dp[i]=Math.min(l.get(i)+dp[i-1],one);
                   
                }
                else
                {
                    one+=l.get(i);
                    dp[i]=dp[i-1];
                }
            }
  
            return dp[dp.length-1];
        }
        else
        {
            int one=l.get(0);
            for(int i=1;i<l.size();i++)
            {
                if(i%2!=0)
                {
                 dp[i]=Math.min(l.get(i)+dp[i-1],one);
                }
                else
                {
                    one+=l.get(i);
                    dp[i]=dp[i-1];
                }
            }
            
        }
     
        return dp[dp.length-1];

    }
}
