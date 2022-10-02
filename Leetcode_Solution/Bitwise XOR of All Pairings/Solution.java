class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums2.length%2==0 && nums1.length%2==0)
        {
            return 0;
        }
        else if(nums2.length%2==0)
        {
            int result=0;
            for(int i=0;i<nums2.length;i++)
            {
                result=result^nums2[i];
            }
            return result;
        }
        else if(nums1.length%2==0)
        {
            int result=0;
            for(int i=0;i<nums1.length;i++)
            {
                result=result^nums1[i];
            }
            return result;
        }
        else
        {
            int result=0;
            for(int i=0;i<nums2.length;i++)
            {
                result=result^nums2[i];
            }
            for(int i=0;i<nums1.length;i++)
            {
                result=result^nums1[i];
            }
            return result;
        }
    }
}
