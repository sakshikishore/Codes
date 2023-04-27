class Solution {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(nums.length==1)
        {
            result.add(0);
            return result;
        }

        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(nums[nums.length-1]);
        int arr[]=new int[nums.length];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(l.size()==1)
            {
                if(l.get(0)>=nums[i])
                {
                    l.add(0,nums[i]);
                }
                else
                {
                    arr[i]=1;
                    l.add(nums[i]);
                }
            }
            else
            {
                int low=0,high=l.size()-1;
                int index=0;
                while(low<=high)
                {
                      int mid=(low+high)/2;
                      if(l.get(mid)>=nums[i])
                      {
                          index=mid;
                          high=mid-1;
                      }
                      else
                      {
                          low=mid+1;
                          index=low;
                      }
                }
                arr[i]=index;
                l.add(index,nums[i]);
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            result.add(arr[i]);
        }


        return result;

    }
}
