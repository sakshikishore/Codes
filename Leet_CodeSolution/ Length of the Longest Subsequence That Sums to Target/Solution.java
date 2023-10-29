class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {                 Collections.sort(nums);
        Boolean dp[][]=new Boolean[nums.size()][target+1];
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<=target;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            list.add(l);
        }
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=false;
            }
        }
        for(int i=0;i<nums.size();i++)
        {
            for(int p=0;p<nums.get(i) && p<=target;p++)
            {
                if(i!=0)
                {
                    if(dp[i-1][p]==true)
                    {
                        dp[i][p]=true;
                    }
                }
            }
            for(int j=nums.get(i);j<=target;j++)
            {
                if(nums.get(i)==j)
                {
                    dp[i][j]=true;
                    if(list.get(j).size()==0 || list.get(j).size()==1)
                    {
                        list.get(j).add(1);
                    }
                   
                   
                }
                else
                {   
                    if(i!=0)
                    {
                    int x=j-nums.get(i);
                    if(dp[i-1][x]==true)
                    {
                        dp[i][j]=true;
                        int a=list.get(x).get(0);
                        if(list.get(j).size()==0 || list.get(j).size()==1)
                        {
                            list.get(j).add(a+1);
                        }
                        else
                        {
                            int b=list.get(j).get(0);
                           int c=list.get(j).get(1);
                            if(b>c)
                            {

                                list.get(j).remove(1);
                                list.get(j).add(a+1);
                            }
                            else
                            {
                                list.get(j).remove(0);
                                list.get(j).add(a+1);
                            }
                            
                        }
                        
                        
                    }
                    else
                    {
                        if(dp[i-1][j]==true)
                        {
                            dp[i][j]=true;
                            
                        }
                        else
                        {
                            dp[i][j]=false;
                        }
                    }
                }
                    else
                    {
                      dp[i][j]=false;
                    }
                }
                
            }
        }
        if(list.get(target).size()==0)
        {
            return -1;
        }
        else
        {
           
            int len=list.get(target).get(0);
            if(list.get(target).size()==1)
            {
                return len;
            }
             int len2=list.get(target).get(1);
             return Math.max(len,len2);
        }
    }
}
