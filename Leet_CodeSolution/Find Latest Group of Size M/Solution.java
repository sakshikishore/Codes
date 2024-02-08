class Solution {
    public int findLatestStep(int[] arr, int m) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        HashMap<Integer,Integer> left=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> right=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int res=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(list.size()==0)
            {
                list.add(arr[i]);
                left.put(arr[i],1);
                right.put(arr[i],1);
                map.put(1,1);
                 if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
            }
            else
            {
                int low=0,high=list.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>arr[i])
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
                list.add(index,arr[i]);
                if(index==0)
                {
                    if(list.get(1)-arr[i]==1)
                    {         
                        int x=left.get(list.get(1));
                        int p=list.get(1)+(x-1);  
                        left.remove(list.get(1)); 
                        left.put(arr[i],x+1);
                        right.put(p,x+1);
                       
                        if(map.get(x)==1)
                        {
                            map.remove(x);
                        }
                        else
                        {
                            map.put(x,map.get(x)-1);
                        }
                        if(map.containsKey(x+1))
                        {
                            map.put(x+1,map.get(x+1)+1);
                        }
                        else
                        {
                            map.put(x+1,1);
                        }
                         if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                    }
                    else
                    {
                        left.put(arr[i],1);
                        right.put(arr[i],1);
                       
                        if(map.containsKey(1))
                        {
                            map.put(1,map.get(1)+1);
                        }
                        else
                        {
                            map.put(1,1);
                        }
                         if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                    }
                }
                else
                {
                    if(index==list.size()-1)
                    {
                        if(list.get(index)==list.get(index-1)+1)
                        {
                            int p=list.get(index-1);
                            int x=right.get(p);
                            int k=p-(x-1);
                            left.put(k,x+1);
                            right.remove(p);
                            right.put(arr[i],x+1);
                           
                              if(map.get(x)==1)
                                {
                                    map.remove(x);
                                }
                                else
                                {
                                    map.put(x,map.get(x)-1);
                                }
                                if(map.containsKey(x+1))
                                {
                                    map.put(x+1,map.get(x+1)+1);
                                }
                                else
                                {
                                    map.put(x+1,1);
                                }
                                 if(map.containsKey(m))
                                {
                                    res=i+1;
                                }

                        }
                        else
                        {
                            left.put(arr[i],1);
                            right.put(arr[i],1);
                            
                            if(map.containsKey(1))
                            {
                                map.put(1,map.get(1)+1);
                            }
                            else
                            {
                                map.put(1,1);
                            }
                             if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                        }
                    }
                    else
                    {
                        if(list.get(index-1)+1==list.get(index) && list.get(index+1)==list.get(index)+1)
                        {
                            int p=list.get(index-1);
                            int q=list.get(index+1);
                            int x=right.get(p);
                            int y=left.get(q);
                            int k=p-(x-1);
                            int l=q+y-1;
                            left.put(k,x+1+y);
                            right.put(l,x+1+y);
                                if(map.get(x)==1)
                                {
                                    map.remove(x);
                                }
                                else
                                {
                                    map.put(x,map.get(x)-1);
                                }
                                if(map.get(y)==1)
                                {
                                    map.remove(y);
                                }
                                else
                                {
                                    map.put(y,map.get(y)-1);
                                }
                                if(map.containsKey(x+1+y))
                                {
                                    map.put(x+1+y,map.get(x+1+y)+1);
                                }
                                else
                                {
                                    map.put(x+1+y,1);
                                }
                                if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                        }
                        else if(list.get(index-1)+1==list.get(index))
                        {
                            int p=list.get(index-1);
                            int x=right.get(p);
                            int k=p-(x-1);
                            left.put(k,x+1);
                            right.remove(p);
                            right.put(arr[i],x+1);
                           
                            if(map.get(x)==1)
                            {
                                map.remove(x);
                            }
                            else
                            {
                                map.put(x,map.get(x)-1);
                            }
                            if(map.containsKey(x+1))
                            {
                                map.put(x+1,map.get(x+1)+1);
                            }
                            else
                            {
                                map.put(x+1,1);
                            }
                             if(map.containsKey(m))
                                {
                                    res=i+1;
                                }

                        }
                        else if(list.get(index+1)==list.get(index)+1)
                        {
                             int q=list.get(index+1);
                             int y=left.get(q);
                             int l=q+y-1;
                             left.remove(q);
                             left.put(arr[i],1+y);
                             right.put(l,1+y);
                             if(map.get(y)==1)
                                {
                                    map.remove(y);
                                }
                                else
                                {
                                    map.put(y,map.get(y)-1);
                                }
                                if(map.containsKey(y+1))
                                {
                                    map.put(y+1,map.get(y+1)+1);
                                }
                                else
                                {
                                    map.put(y+1,1);
                                }
                                 if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                        }
                        else
                        {
                            left.put(arr[i],1);
                            right.put(arr[i],1);
                            if(map.containsKey(1))
                            {
                                map.put(1,map.get(1)+1);
                            }
                            else
                            {
                                map.put(1,1);
                            }
                             if(map.containsKey(m))
                                {
                                    res=i+1;
                                }
                        }
                    }
                }
            }
        }

        return res;
    }
}
