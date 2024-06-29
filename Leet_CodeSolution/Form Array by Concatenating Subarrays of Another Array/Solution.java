class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(nums[i]);
                l.add(i);
                h.put(nums[i],l);
            }
        }
        int k=0;
        for(int i=0;i<groups.length;i++)
        {
            if(!h.containsKey(groups[i][0]))
            {
                return false;
            }
             ArrayList<Integer> l=h.get(groups[i][0]);
             int index=0,low=0,high=l.size()-1;
             while(low<=high)
             {
                int mid=(low+high)/2;
                if(l.get(mid)>=k)
                {
                    index=mid;
                    high=mid-1;
                }
                else
                {
                    index=mid+1;
                    low=mid+1;
                }
             }
             if(index==l.size())
             {
                return false;
             }
             int temp=0;
             for(int j=index;j<l.size();j++)
             {
                int flag=0;
                if(l.get(j)+groups[i].length>nums.length)
                {
                    return false;
                }
                int count=0;
                for(int p=l.get(j);p<l.get(j)+groups[i].length;p++)
                {
                    if(nums[p]!=groups[i][count])
                    {
                        flag=1;
                        break;
                    }
                    count++;
                }
                if(flag==0)
                {
                    temp=1;
                    k=l.get(j)+groups[i].length;
                    break;
                }
             }

             if(temp==0)
             {
                return false;
             }
        }

        return true;
    }
}
