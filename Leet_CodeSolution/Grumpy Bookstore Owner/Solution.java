class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans=0,max=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
         ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
            {
                ans+=customers[i];
            }
            else
            {
                l.add(i);
            }
        }
        max=ans;
        int dp[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
        {
           if(list.size()==0)
           {
               list.add(l.get(i));   
               ans=ans+customers[l.get(i)];
               dp[i]=ans;
           }
           else
           {
               while(list.size()>0 && l.get(i)-list.get(0)>=minutes)
                    {
                        ans=ans-customers[list.get(0)];
                        list.remove(0);
                    }
                    list.add(l.get(i));
                    ans=ans+customers[l.get(i)];
                    dp[i]=ans;
           }
 
           if(dp[i]>max)
           {
               max=dp[i];
           }
        }

        return max;
    }
}
