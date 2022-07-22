class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int arr[][]=new int[nums1.length][nums2.length];
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(i==0 || j==0)
                {
                    if(nums1[i]==nums2[j])
                    {
                        arr[i][j]=1;
                        if(max==0)
                        {
                            max=1;
                        }
                    }
                }
                else
                {
                    if(nums1[i]==nums2[j])
                    {
                        arr[i][j]=arr[i-1][j-1]+1;
                        if(arr[i][j]>max)
                        {
                            max=arr[i][j];
                        }
                    }
                }
            }
        }
        
        return max;
    }
}
