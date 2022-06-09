class Solution {
    public boolean increasingTriplet(int[] nums) {
        TreeSet<Integer> t=new TreeSet<Integer>();
        boolean result=false;
        for(int i=0;i<nums.length;i++)
        {
            t.add(nums[i]);
        }
        if(t.size()>2)
        {
            int arr[]=new int[nums.length];
            arr[0]=1;
            for(int i=1;i<nums.length;i++)
            {
                int max=0;
                for(int j=0;j<i;j++)
                {
                    if(nums[j]<nums[i])
                    {
                        if(max<arr[j])
                        {
                            max=arr[j];
                        }
                    }
                }

                arr[i]=max+1;
                if(arr[i]>2)
                {
                    result=true;
                    break;
                }
            }
        }
        
        
        return result;
        
    }
}
