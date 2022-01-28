class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int arr[]=new int[nums.length];
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        int result[]=new int[k];
        Arrays.sort(nums);
        int l=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
            l++;
            if(l==k)
            {
                break;
            }
        }
        int p=0;
        for(int i=0;i<arr.length;i++)
        {
            if(h.containsKey(arr[i]))
            {
                if(h.get(arr[i])==1)
                {
                    result[p]=arr[i];
                    p++;
                    h.remove(arr[i]);
                }
                else
                {
                    result[p]=arr[i];
                    p++;
                    h.put(arr[i],h.get(arr[i])-1);
                }
            }
        }
        return result;
    }
}
