class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                l.add(nums[i]);
                h.put(nums[i],nums[i]);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+nums[i]);
            }
        }
        if(l.size()==1)
        {
            return h.get(l.get(0));
        }
        Collections.sort(l);
        int arr[]=new int[l.size()];
        arr[0]=h.get(l.get(0));
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i)-l.get(i-1)==1)
            {
                if(i==1)
                {
                    arr[i]=h.get(l.get(i));
                }
                else if(i==2)
                {
                  arr[i]=h.get(l.get(i))+arr[0];
                }
                else
                {
                    arr[i]=h.get(l.get(i))+(int)Math.max(arr[i-2],arr[i-3]);
                }
            }
            else
            {
                if(i==1)
                {
                    arr[i]=arr[0]+h.get(l.get(i));
                }
                else
                {
                  arr[i]=h.get(l.get(i))+(int)Math.max(arr[i-2],arr[i-1]);;
                }
            }
        }

        return Math.max(arr[arr.length-2],arr[arr.length-1]);
    }
}
