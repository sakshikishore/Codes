class Solution {
    public int longestSubarray(int[] nums) {
         if(nums.length==1)
        {
            return 1;
        }
        int pref[]=new int[nums.length];
        pref[0]=1;
        for(int i=1;i<nums.length;i++)
            {
                if(nums[i-1]<=nums[i])
                {
                    pref[i]=pref[i-1]+1;
                }
                else
                {
                    pref[i]=1;
                }
            }
        int suf[]=new int[nums.length];
        suf[suf.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
            {
                if(nums[i]<=nums[i+1])
                {
                    suf[i]=suf[i+1]+1;
                }
                else
                {
                    suf[i]=1;
                }
            }
        int ans=1;
        for(int i=0;i<nums.length;i++)
            {
                if(i==0)
                {
                   ans=Math.max(suf[i+1]+1,ans);
                }
                else if(i==nums.length-1)
                {
                    ans=Math.max(ans,pref[i-1]+1);
                }
                else
                {
                    if(nums[i-1]<=nums[i+1])
                    {
                        ans=Math.max(ans,pref[i-1]+suf[i+1]+1);
                    }
                    else
                    {
                        int ans1=pref[i-1]+1;
                        int ans2=1+suf[i+1];
                        ans1=Math.max(ans1,ans2);
                        ans=Math.max(ans,ans1);
                    }
                }
            }

        return ans;

        }
}
