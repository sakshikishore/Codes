class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)=='1')
        {
            return false;
        }
        boolean dp[]=new boolean[s.length()];
        dp[0]=true;
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(0);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                if(i-minJump>=0)
                {
                    int high=i-minJump;
                    int low=Math.max(i-maxJump,0);
                    if(low>al.get(al.size()-1))
                    {
                        dp[i]=false;
                    }
                    else
                    {
                          int l=0,h=al.size()-1,lIndex=0;
                          while(l<=h)
                          {
                            int mid=(l+h)/2;
                            if(al.get(mid)==low || al.get(mid)==high)
                            {
                                dp[i]=true;
                                break;
                            }
                            else if(al.get(mid)>low)
                            {
                                lIndex=mid;
                                h=mid-1;
                            }
                            else
                            {
                                lIndex=mid+1;
                                l=mid+1;
                            }
                          }
                          if(!dp[i])
                          {
                            if(lIndex!=al.size())
                            {
                                if(al.get(lIndex)<=high)
                                {
                                    dp[i]=true;
                                    al.add(i);
                                }
                            }
                          }
                          else
                          {
                            al.add(i);
                          }
                    }
                
                }
            }
            
        }

        if(dp[s.length()-1])
         {
            return true;
         }
         return false;
    }
}
