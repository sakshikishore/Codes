class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!h.containsKey(nums[i])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i], l);
            } else {
                ArrayList<Integer> l = h.get(nums[i]);
                l.add(i);
                h.put(nums[i], l);
            }
        }
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<queries.length;i++)
            {
                if(map.containsKey(queries[i]))
                {
                    result.add(map.get(queries[i]));
                }
                else
                {
                    ArrayList<Integer> l=h.get(nums[queries[i]]);
                    if(l.size()==1)
                    {
                       map.put(queries[i],-1);
                       result.add(-1);
                    }
                    else
                    {
                        int low=0,high=l.size()-1,index=0;
                        while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)==queries[i])
                                {
                                    index=mid;
                                    break;
                                }
                                else
                                {
                                    if(l.get(mid)>queries[i])
                                    {
                                        high=mid-1;
                                    }
                                    else
                                    {
                                        low=mid+1;
                                    }
                                }
                            }
                        if(index==l.size()-1)
                        {
                            int p=l.get(0);
                            int q=l.get(l.size()-2);
                            if(queries[i]-q>(p-queries[i]+nums.length)%nums.length)
                            {
                                result.add((p-queries[i]+nums.length)%nums.length);
                                map.put(queries[i],(p-queries[i]+nums.length)%nums.length);
                            }
                            else
                            {
                                result.add(queries[i]-q);
                                map.put(queries[i],queries[i]-q);
                            }
                        }
                        else if(index==0)
                        {
                            int p=l.get(l.size()-1);
                            int q=l.get(1);
                            if(q-queries[i]>(queries[i]-p+nums.length)%nums.length)
                            {
                                result.add((queries[i]-p+nums.length)%nums.length);
                                map.put(queries[i],(queries[i]-p+nums.length)%nums.length);
                            }
                            else
                            {
                                 result.add(q-queries[i]);
                                map.put(queries[i],q-queries[i]);
                            }
                        }
                        else
                        {
                            int p=l.get(index-1);
                            int q=l.get(index+1);
                            if(queries[i]-p>q-queries[i])
                            {
                                 result.add(q-queries[i]);
                                map.put(queries[i],q-queries[i]);
                            }
                            else
                            {
                                result.add(queries[i]-p);
                                map.put(queries[i],queries[i]-p);
                            }
                        }
                    }
                }
            }

        return result;
    }
}
