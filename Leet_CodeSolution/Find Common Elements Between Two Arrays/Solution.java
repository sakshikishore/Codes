class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> h1=new HashSet<Integer>();
        HashSet<Integer> h2=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            h1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            h2.add(nums2[i]);
        }
        int count1=0,count2=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(h2.contains(nums1[i]))
            {
                count1++;
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
           if(h1.contains(nums2[i]))
            {
                count2++;
            }
        }
        
        int result[]=new int[2];
        result[0]=count1;
        result[1]=count2;
        
        return result;
        
        
        
    }
}
