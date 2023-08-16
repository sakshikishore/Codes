/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low=0,high=mountainArr.length()-1;
        int ans=-1;
        int peak=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid==0)
            {
                break;
            }
            if(mountainArr.get(mid)>mountainArr.get(mid-1))
            {
                peak=mid;
                low=mid+1;
            }
            else
            {
                peak=mid-1;
                high=mid-1;
            }
            
        }
        low=0;
        high=peak;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mountainArr.get(mid)==target)
            {
                ans=mid;
                break;
            }
            else if(mountainArr.get(mid)>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        if(ans==-1)
        {
            low=peak+1;
            high=mountainArr.length()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(mountainArr.get(mid)==target)
                {
                    ans=mid;
                    break;
                }
                else if(mountainArr.get(mid)>target)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }

      return ans;
    }
}
