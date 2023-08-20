class Solution {
    public long continuousSubarrays(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        long count=0;
        int start=0;
        for(int i=0;i<nums.length;i++)
        {
            h.put(nums[i],i);
            if(l.size()==0)
            {
                l.add(nums[i]);
                count+=l.size();
            }
            else
            {
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>nums[i])
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
                l.add(index,nums[i]);
                if(l.get(l.size()-1)-l.get(0)<=2)
                {
                    count+=l.size();
                }
                else
                {
                    while(l.size()>0)
                    {
                           int x=0;
                           if(index==0)
                           {
                             x=h.get(l.get(l.size()-1));
                             l.remove(l.size()-1);
                           }
                           else if(index==l.size()-1)
                           {
                               x=h.get(l.get(0));
                               l.remove(0);
                           }
                           else
                           {
                               x=Math.min(h.get(l.get(l.size()-1)),h.get(l.get(0)));
                           }
                           for(int j=start;j<x;j++)
                           {
                               low=0;
                               high=l.size()-1;
                               while(low<=high)
                               {
                                  int mid=(low+high)/2;
                                  if(l.get(mid)==nums[j])
                                  {
                                      l.remove(mid);
                                      break;
                                  }
                                  else if(l.get(mid)>nums[j])
                                  {
                                      high=mid-1;
                                  }
                                  else
                                  {
                                      low=mid+1;
                                  }
                               }
                               
                           }
                           start=x+1;
                           if(l.size()==1 || (l.size()>1 && l.get(l.size()-1)-l.get(0)<=2))
                           {
                               count+=l.size();
                               break;
                           }
                    }
                }
            }
        }

        return count;
    }
}
