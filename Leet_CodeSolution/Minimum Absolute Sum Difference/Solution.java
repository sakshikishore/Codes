class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
         int arr[]=new int[nums1.length];
        long result=0;
        for(int i=0;i<nums1.length;i++)
        {
            arr[i]=nums1[i];
            result+=Math.abs(nums1[i]-nums2[i]);

        }
        if(result==0)
        {
            return (int)(result%(1000000007));
        }
        long min=result;
        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++)
        {
            int low=0,high=nums1.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums1[mid]>nums2[i])
                {
                    high=mid-1;
                }
                else if(nums1[mid]==nums2[i])
                {
                     low=mid;
                     break;
                }
                else
                {
                    low=mid+1;
                }
            }
           
            if(low==arr.length)
            {
              long ans=result-Math.abs(arr[i]-nums2[i])+Math.abs(nums1[low-1]-nums2[i]);
               if(ans<min)
               {
                 min=ans;
               }
            }
            else if(low==0)
            {
              long ans=result-Math.abs(arr[i]-nums2[i])+Math.abs(nums1[low]-nums2[i]);
               if(ans<min)
               {
                 min=ans;
               }
            }
            else
            {
                 long ans=result-Math.abs(arr[i]-nums2[i])+Math.abs(nums1[low]-nums2[i]);
               if(ans<min)
               {
                 min=ans;
               }
               
                ans=result-Math.abs(arr[i]-nums2[i])+Math.abs(nums1[low-1]-nums2[i]);
                if(ans<min)
                {
                    min=ans;
                }
               
            }
 
        }
  return (int)(min%(1000000007));
    }
}
