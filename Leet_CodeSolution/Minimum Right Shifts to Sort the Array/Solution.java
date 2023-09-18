class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums.get(i)<min)
            {
                min=nums.get(i);
                index=i;
            }
        }
        
        int result=nums.size()-index;
            int arr[]=new int[nums.size()];
            for(int i=0;i<arr.length;i++)
            {
                arr[(i+result)%nums.size()]=nums.get(i);
            }
           
        int flag=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<arr[i-1])
            {
                flag=1;
                break;
            }

        }
        
        if(flag==0)
        {
            return result%nums.size();
        }
        else
        {
            return -1;
        }
            
    }
}
