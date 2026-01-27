class Solution {
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(k==0)
        {
            return nums;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                l.add(i);
            }
        }
        if(l.size()==0)
        {
            return nums;
        }
        int arr[]=new int[l.size()];
        k=k%l.size();
        for(int i=0;i<l.size();i++)
        {
           arr[(i-k+l.size())%l.size()]=nums[l.get(i)];
        }
        int j=0;
       for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                nums[i]=arr[j];
                j++;
            }
        }

        return nums;
    }
}
