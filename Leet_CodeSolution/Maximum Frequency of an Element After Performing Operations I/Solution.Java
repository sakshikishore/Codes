class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int arr[]=new int[nums[nums.length-1]+1];
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
            if(i==0)
            {
                arr[nums[i]]=1;
                if(nums[i]+k<arr.length-1)
                {
                    arr[nums[i]+k+1]-=1;
                }
            }
            else
            {
                if(nums[i]-k<=nums[0])
                {
                    arr[nums[0]]+=1;
                }
                else
                {
                    arr[nums[i]-k]+=1;
                }
                if(nums[i]+k<arr.length-1)
                {
                    arr[nums[i]+k+1]-=1;
                }
            } 
        }
        int max=0;
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i];
            if(h.containsKey(i))
            {
                int x=h.get(i);
                int t=x+numOperations;
                if(t>arr[i])
                {
                    t=arr[i];
                }
                if(max<t)
                {
                    max=t;
                }

            }
            else
            {
                int t=numOperations;
                if(arr[i]<t)
                {
                    t=arr[i];
                }
                 if(max<t)
                {
                    max=t;
                }
            }
        }

        return max;
    }
}
