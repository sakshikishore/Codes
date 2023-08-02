class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int local=0,global=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
            {
                local++;
            }
        }

        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(l.size()==0)
            {
                l.add(nums[i]);
            }
            else if(l.size()==1)
            {
                if(nums[0]>nums[1])
                {
                    global++;
                    l.add(0,nums[1]);
                }
                else
                {
                    l.add(nums[1]);
                }
            }
            else
            {
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                   int mid=(low+high)/2;
                   if(l.get(mid)>nums[i])
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
                global+=l.size()-index;
                l.add(index,nums[i]);
            }
        }

        if(global==local)
        {
            return true;
        }

        return false;
    }
}
