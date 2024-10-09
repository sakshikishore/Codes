class Solution {
    public long numberOfSubarrays(int[] nums) {
        long result=0;
        int nextGreaterElementIndex[]=new int[nums.length];
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(-1);
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=nums.length-1;i>=0;i--)
        {
            if(!h.containsKey(nums[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(nums[i]);
                l.add(0,i);
                h.put(nums[i],l);
            }
            while(stck.peek()!=-1 && nums[i]>=nums[stck.peek()])
            {
                stck.pop();
            }
            nextGreaterElementIndex[i]=stck.peek();
            stck.push(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nextGreaterElementIndex[i]==-1)
            {
                ArrayList<Integer> l=h.get(nums[i]);
                result+=l.size();
                l.remove(0);
                if(l.size()==0)
                {
                    h.remove(nums[i]);
                }
                else
                {
                    h.put(nums[i],l);
                }

            }
            else
            {
                int p=nextGreaterElementIndex[i];
                ArrayList<Integer> l=h.get(nums[i]);
                int low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>p)
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                result+=low;
                l.remove(0);
                if(l.size()==0)
                {
                    h.remove(nums[i]);
                }
                else
                {
                    h.put(nums[i],l);
                }
                
            }
        }

        return result;
    }
}
