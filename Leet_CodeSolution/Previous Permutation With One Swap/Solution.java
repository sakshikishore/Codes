class Solution {
    public int[] prevPermOpt1(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i==arr.length-1)
            {
                h.put(arr[i],i);
                l.add(arr[i]);
            }
            else
            {
                if(arr[i]>arr[i+1])
                {
                    if(l.size()==1)
                    {
                        int temp=arr[i];
                        arr[i]=arr[i+1];
                        arr[i+1]=temp;
                        break;
                    }
                    else
                    {
                        if(!h.containsKey(arr[i]))
                        {
                            h.put(arr[i],i);
                            int low=0,high=l.size()-1;
                            int index=-1;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)>arr[i])
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
                            int temp=arr[i];
                            int x=h.get(l.get(index-1));
                            arr[i]=arr[x];
                            arr[x]=temp;
                            break;
                        }
                        else
                        {
                            int x=h.get(l.get(l.indexOf(arr[i])-1));
                            int temp=arr[i];
                            arr[i]=arr[x];
                            arr[x]=temp;
                            break;

                        }
                    }
                }
                else
                {
                    if(!h.containsKey(arr[i]))
                    {
                        h.put(arr[i],i);
                        if(l.size()==1)
                        {
                            l.add(0,arr[i]);
                        }
                        else
                        {
                            int low=0,high=l.size()-1;
                            int index=-1;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)>arr[i])
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
                            l.add(index,arr[i]);
                        }
                    }
                    else
                    {
                        h.put(arr[i],i);
                    }
                }
            }
        }

        return arr;
    }
}
