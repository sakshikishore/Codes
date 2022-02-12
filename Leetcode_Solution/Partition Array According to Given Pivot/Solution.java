class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int count=0;
        int arr[]=new int[nums.length];
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot)
            {
                l.add(nums[i]);
            }
            else if(nums[i]==pivot)
            {
                count++;
            }
            else
            {
                m.add(nums[i]);
            }
        }
        int j=0;
        if(l.size()>0)
        {
            for(int i=0;i<l.size();i++)
            {
                arr[j]=l.get(i);
                j++;
            }
        }
        if(count>0)
        {
            for(int i=0;i<count;i++)
            {
                arr[j]=pivot;
                j++;
            }
        }
        if(m.size()>0)
        {
            for(int i=0;i<m.size();i++)
            {
                arr[j]=m.get(i);
                j++;
            }
        }
        
        return arr;
    }
}
