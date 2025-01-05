class Solution {
    public long calculateScore(String s) {
        int arr[]=new int[26];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        int j=0;
        long result=0;
        for(int i=25;i>=0;i--)
            {
                arr[j]=i;
                j++;
            }
        for(int i=0;i<s.length();i++)
            {
                int x=s.charAt(i)-'a';
                if(!h.containsKey(x))
                {
                   ArrayList<Integer> l=new ArrayList<Integer>();
                   l.add(i);
                   h.put(x,l);
                }
                else
                {
                  ArrayList<Integer> l=h.get(x);
                   l.add(i);
                   h.put(x,l);
                }
            }

        for(int i=0;i<s.length();i++)
            {
                int x=s.charAt(i)-'a';
                if(h.containsKey(arr[x]))
                {
                    ArrayList<Integer> l=h.get(arr[x]);
                    int low=0,high=l.size()-1;
                    int index=0;
                    while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>i)
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
                     if(index!=0)
                     {
                         result+=i-(l.get(index-1));
                         l.remove(index-1);
                         h.put(arr[x],l);

                          l=h.get(x);
                       low=0;
                        high=l.size()-1;
                   
                    while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>i)
                            {
                                index=mid;
                                high=mid-1;
                            }
                            else if(l.get(mid)<i)
                            {
                               index=mid+1;
                                low=mid+1;
                                
                            }
                            else
                            {
                                l.remove(mid);
                                break;
                            }
                        }

                         if(l.size()==0)
                         {
                             h.remove(x);
                         }
                     }
                }
            }

        return result;
    }
}
