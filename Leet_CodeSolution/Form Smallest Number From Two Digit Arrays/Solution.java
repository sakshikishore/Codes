class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            h.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(h.contains(nums2[i]))
            {
                return nums2[i];
            }
        }
        
        if(nums1[0]>nums2[0])
        {
            return nums2[0]*10+nums1[0];
        }
       return nums1[0]*10+nums2[0];
    }
}
