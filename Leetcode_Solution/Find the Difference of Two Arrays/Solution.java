class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<nums1.length;i++)
        {
            l1.add(nums1[i]);
        }
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        for(int i=0;i<nums2.length;i++)
        {
            l2.add(nums2[i]);
            if(!l1.contains(nums2[i]))
            {
                if(!arr2.contains(nums2[i]))
                {
                    arr2.add(nums2[i]);
                }
            }
        }
         ArrayList<Integer> arr1=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            if(!l2.contains(nums1[i]))
            {
                if(!arr1.contains(nums1[i]))
                {
                    arr1.add(nums1[i]);
                }
            }
        }
        list.add(arr1);
        list.add(arr2);
        
        
        return list;
        
    }
}
