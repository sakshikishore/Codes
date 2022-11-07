class Solution {
    public int[] applyOperations(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]*=2;
                if(nums[i]!=0)
                {
                    l.add(nums[i]);
                }
                nums[i+1]=0;
            }
            else
            {
                if(nums[i]!=0)
                {
                    l.add(nums[i]);
                }
            }
        }
        if(nums[nums.length-1]!=0)
        {
            l.add(nums[nums.length-1]);
        }
        int arr[]=new int[nums.length];
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(j<l.size())
            {
                arr[j]=l.get(j);
            }
            else
            {
                break;
            }
            j++;
        }
        
        return arr;
    }
}
