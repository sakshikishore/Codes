class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        int result[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int x=queries[i][0];
            int y=queries[i][1];
            if(!h2.containsKey(x))
            {
                h2.put(x,y);
                if(h1.containsKey(y))
                {
                    ArrayList<Integer> l=h1.get(y);
                    int low=0,high=l.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>=x)
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
                    h1.put(y,l);
                }
                else
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(x);
                    h1.put(y,l);
                }
            }
            else
            {
                int color=h2.get(x);
                h2.put(x,y);
                ArrayList<Integer> l=h1.get(color);
                if(l.size()==1)
                {
                    h1.remove(color);
                }
                else
                {
                    int low=0,high=l.size()-1;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)==x)
                        {
                            l.remove(mid);
                            break;
                        }
                        if(l.get(mid)>x)
                        {
                            high=mid-1;
                        }
                        else
                        {
                            low=mid+1;
                        }
                    }
                }
                if(h1.containsKey(y))
                {
                     l=h1.get(y);
                    int low=0,high=l.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)>=x)
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
                    h1.put(y,l);
                }
                else
                {
                    l=new ArrayList<Integer>();
                    l.add(x);
                    h1.put(y,l);
                }
            }
            
            result[i]=h1.size();
        }
        
        return result;
    }
}
