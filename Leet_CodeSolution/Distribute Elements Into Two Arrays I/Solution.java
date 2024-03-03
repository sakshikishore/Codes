class Solution {
    public int[] resultArray(int[] nums) {
        int result[]=new int[nums.length];
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int k=2;
        while(k<nums.length)
        {
            if(l1.get(l1.size()-1)<l2.get(l2.size()-1))
            {
                l2.add(nums[k]);
            }
            else{
                l1.add(nums[k]);
            }
            k++;
        }
        int j=0;
        for(int i=0;i<l1.size();i++)
        {
            result[j]=l1.get(i);
            j++;
        }
        for(int i=0;i<l2.size();i++)
        {
            result[j]=l2.get(i);
            j++;
        }
    
    return result;
    }
}
