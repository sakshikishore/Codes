class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        // Case 1 -  don't swap last element
        int a[]=new int[nums1.length];
        int b[]=new int[nums2.length];
        for(int i=0;i<nums1.length;i++)
        {
           a[i]=nums1[i];
           b[i]=nums2[i];
        }
        int result=0;
        for(int i=0;i<nums1.length-1;i++)
        {
            if(nums1[i]>nums1[nums1.length-1])
            {
                if(nums2[i]<nums1[nums1.length-1])
                {
                     if(nums1[i]>nums2[nums2.length-1])
                     {
                         result=-1;
                         break;
                     }
                     else
                     {
                         int temp=nums1[i];
                         nums1[i]=nums2[i];
                         nums2[i]=temp;
                         result++;
                     }
                }
                else
                {
                    result=-1;
                    break;
                }
            }
            else if(nums2[i]>nums2[nums2.length-1])
            {
                if(nums1[i]<=nums2[nums2.length-1])
                {
                     if(nums2[i]>nums1[nums1.length-1])
                     {
                         result=-1;
                         break;
                     }
                     else
                     {
                         int temp=nums1[i];
                         nums1[i]=nums2[i];
                         nums2[i]=temp;
                         result++;
                     }
                }
                else
                {
                    result=-1;
                    break;
                }
            }
        }

        int count=result;

        // Case 2 swap nums1[nums1.length-1] && nums2[nums2.length-1]
        nums1=a;
        nums2=b;
        result=1;
        int temp=nums1[nums1.length-1];
        nums1[nums1.length-1]=nums2[nums2.length-1];
        nums2[nums2.length-1]=temp;
        for(int i=0;i<nums1.length-1;i++)
        {
            if(nums1[i]>nums1[nums1.length-1])
            {
                if(nums2[i]<=nums1[nums1.length-1])
                {
                     if(nums1[i]>nums2[nums2.length-1])
                     {
                         result=-1;
                         break;
                     }
                     else
                     {
                         
                         temp=nums1[i];
                         nums1[i]=nums2[i];
                         nums2[i]=temp;
                         result++;
                     }
                }
                else
                {
                    result=-1;
                    break;
                }
            }
            else if(nums2[i]>nums2[nums2.length-1])
            {
                if(nums1[i]<nums2[nums2.length-1])
                {
                     if(nums2[i]>nums1[nums1.length-1])
                     {
                         result=-1;
                         break;
                     }
                     else
                     {
                         temp=nums1[i];
                         nums1[i]=nums2[i];
                         nums2[i]=temp;
                         result++;
                     }
                }
                else
                {
                    result=-1;
                    break;
                }
            }
        }
        if(result==-1 && count==-1)
        {
            return -1;
        }
        else if(result==-1)
        {
            return count;
        }
        else if(count==-1)
        {
            return result;
        }
        return Math.min(result,count);

    }
}
