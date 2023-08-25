class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(1);
                h.put(nums[i],l);
            }
            else
            {
                if(h.containsKey(nums[i]-1))
                {
                    ArrayList<Integer> l=h.get(nums[i]-1);
                    int x=l.get(0);
                    l.remove(0);
                    if(l.size()==0)
                    {
                        h.remove(nums[i]-1);
                    }
                    else
                    {
                        h.put(nums[i]-1,l);
                    }
                    x=x+1;
                    if(!h.containsKey(nums[i]))
                    {
                        l=new ArrayList<Integer>();
                        l.add(x);
                        h.put(nums[i],l);
                    }
                    else
                    {
                          l=h.get(nums[i]);
                          int low=0,high=l.size()-1,index=0;
                          while(low<=high)
                          {
                              int mid=(low+high)/2;
                              if(l.get(mid)>x)
                              {
                                  index=mid;
                                  high=mid-1;
                              }
                              else
                              {
                                  index=mid+1;
                                  low=mid+1;
                              }
                          }
                          l.add(index,x);
                        h.put(nums[i],l);
                    }

                }
                else
                {
                    if(!h.containsKey(nums[i]))
                    {
                       ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(1);
                        h.put(nums[i],l);
                    }
                    else
                    {
                        ArrayList<Integer> l=h.get(nums[i]);
                          l.add(0,1);
                          h.put(nums[i],l);
                    }
                }
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
        {
            ArrayList<Integer> al=entry.getValue();
            for(int i=0;i<al.size();i++)
            {
                if(al.get(i)<3)
                {
                    return false;
                }
            }
        }

        return true;
    }
}
