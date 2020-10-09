class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        double result=0.0;
        int i=0,j=0,k=0;
        while(i!=nums1.length && j!=nums2.length)
        {
            if(nums1[i]<=nums2[j])
            {
                arr[k]=nums1[i];
                i++;
            }
            else
            {
                arr[k]=nums2[j];
                j++;
            }
            k++;
        }
        
        
        if(i!=nums1.length)
        {
            for(int l=i;l<nums1.length;l++)
            {
                arr[k]=nums1[l];
                k++;
            }
        }
        if(j!=nums2.length)
        {
            for(int l=j;l<nums2.length;l++)
            {
                arr[k]=nums2[l];
                k++;
            }
        }
        if(arr.length%2==0)
        {
            int p=arr.length/2;
            double l=arr[p];
            double m=arr[p-1];
            result=(l+m)/2.0;
            
        }
        else
        {
            int p=arr.length/2;
            double l=arr[p];
            result=l;
        }
        
        
        return result;
    }
    
    
}
