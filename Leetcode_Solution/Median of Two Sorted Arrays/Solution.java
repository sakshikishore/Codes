class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[]=new int[nums1.length+nums2.length];
        double result=0.0;
        for(int i=0;i<nums1.length;i++)
        {
            arr[i]=nums1[i];
        }
        
        int k=0;
        for(int j=nums1.length;j<nums1.length+nums2.length;j++)
        {
            arr[j]=nums2[k];
            k++;
        }
        
        Arrays.sort(arr);
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
