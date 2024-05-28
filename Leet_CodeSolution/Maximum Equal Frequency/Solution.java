class Solution {
    public int maxEqualFreq(int[] nums) {
        int max=1;
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                if(!h1.containsKey(1))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    h1.put(1,list);
                }
                else
                {
                    ArrayList<Integer> list=h1.get(1);
                    int low=0,high=list.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(list.get(mid)>=nums[i])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            low=mid+1;
                            index=mid+1;
                        }
                    }
                    list.add(index,nums[i]);
                    h1.put(1,list);
                }
            }
            else
            {
                int x=h.get(nums[i]);
                h.put(nums[i],x+1);
                ArrayList<Integer> l=h1.get(x);
                int low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)==nums[i])
                    {
                        l.remove(mid);
                        break;
                    }
                    else if(l.get(mid)>nums[i])
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                if(l.size()==0)
                {
                    h1.remove(x);
                }
                else
                {
                    h1.put(x,l);
                }


                if(!h1.containsKey(x+1))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    h1.put(x+1,list);
                }
                else
                {
                    ArrayList<Integer> list=h1.get(x+1);
                    low=0;
                    high=list.size()-1;
                    int index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(list.get(mid)>=nums[i])
                        {
                            index=mid;
                            high=mid-1;
                        }
                        else
                        {
                            low=mid+1;
                            index=mid+1;
                        }
                    }
                    list.add(index,nums[i]);
                    h1.put(x+1,list);
                }

            }

            if(h1.size()==1 && h.size()==1)
            {
                max=h.get(nums[i]);
            }
            else if(h1.size()==1)
            {
                if(h.get(nums[i])==1)
                {
                    ArrayList<Integer> al=h1.get(1);
                    if(al.size()>max)
                    {
                        max=al.size();
                    }
                }
            }
            else if(h1.size()==2)
            {
                int flag=0,k1=0,x1=0,x2=0,k2=0;
                for(Map.Entry<Integer,ArrayList<Integer>> entry:h1.entrySet())
                {
                   if(flag==0)
                   {
                    k1=entry.getKey();
                    ArrayList<Integer> val=entry.getValue();
                    x1=val.size();
                    flag=1;
                   }
                   else
                   {
                        k2=entry.getKey();
                        ArrayList<Integer> val=entry.getValue();
                        x2=val.size();     
                   }

                }

                if((k1==1 && x1==1) || (k2==1 && x2==1) || (k1-k2==1 && x1==1) 
                ||(k2-k1==1 && x2==1))
                {
                  int res=(x1*k1)+(x2*k2);
                  if(res>max)
                  {
                    max=res;
                  }
                }
            }

            
            
        }

        return max;
    }
}
