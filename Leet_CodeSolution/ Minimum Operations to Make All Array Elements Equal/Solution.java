class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        ArrayList<Long> result=new ArrayList<Long>();
        long pref[]=new long[nums.length];
        pref[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           pref[i]=pref[i-1]+nums[i];
        }
        long suf[]=new long[nums.length];
        suf[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
             suf[i]=suf[i+1]+nums[i];
        }

        for(int i=0;i<queries.length;i++)
        {
            int low=0,high=nums.length-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums[mid]>queries[i])
                {
                    index=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                    index=mid+1;
                }
            }
            if(index==0)
            {
                long p=nums.length;
                result.add(suf[0]-(p*queries[i]));
            }
            else if(index==nums.length)
            {
                long p=nums.length;
                result.add((p*queries[i])-pref[nums.length-1]);
            }
            else
            {
                long p=nums.length-index;
                long res=suf[index]-(p*queries[i]);
                res=res+(1L*index*queries[i]-pref[index-1]);
                result.add(res);
            }

        }

        return result;
    }
}
