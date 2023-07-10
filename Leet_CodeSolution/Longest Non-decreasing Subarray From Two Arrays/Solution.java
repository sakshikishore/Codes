class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        arr[arr.length-1]=1;
        arr[arr.length-2]=1;
        int p=arr.length-3;
        int max=1;
        for(int i=nums1.length-2;i>=0;i--)
        {
                arr[p]=1;
                if(nums1[i+1]>=nums2[i])
                {
                    arr[p]=arr[p+1]+1;
                }
                if(nums2[i+1]>=nums2[i])
                {
                    if(arr[p+2]+1>arr[p])
                    {
                        arr[p]=arr[p+2]+1;
                    }
                }
            if(arr[p]>max)
            {
                max=arr[p];
            }
            p--;
              arr[p]=1;
              if(nums1[i+1]>=nums1[i])
                {
                    arr[p]=arr[p+2]+1;
                }
                if(nums2[i+1]>=nums1[i])
                {
                    if(arr[p+3]+1>arr[p])
                    {
                        arr[p]=arr[p+3]+1;
                    }
                }
             if(arr[p]>max)
            {
                max=arr[p];
            }
            p--;
        }
        
        return max;
    }
}
