class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int result[]=new int[numberOfUsers];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<events.size();i++)
        {
             List<String> list=events.get(i);
             if(list.get(0).equals("OFFLINE"))
             {
                int id =Integer.parseInt(list.get(2));
                int time=Integer.parseInt(list.get(1));
                if(!h.containsKey(id))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(time);
                    h.put(id,l);
                }
                else
                {
                   ArrayList<Integer> l=h.get(id);
                    l.add(time);
                    h.put(id,l);
                }
             }
        }

        for(int i=0;i<events.size();i++)
        {
            List<String> list=events.get(i);
            if(list.get(0).equals("MESSAGE"))
            {
                if(list.get(2).equals("ALL"))
                {
                    for(int j=0;j<result.length;j++)
                    {
                         result[j]+=1;
                    }  
                }
                else if(list.get(2).equals("HERE"))
                {
                   int time=Integer.parseInt(list.get(1));
                   for(int j=0;j<result.length;j++)
                    {
                         if(!h.containsKey(j))
                         {
                         result[j]+=1;
                         }
                         else
                         {
                            ArrayList<Integer> l=h.get(j);
                            Collections.sort(l);
                            int low=0,high=l.size()-1,index=0;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)>time)
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

                            if(index==0)
                            {
                                result[j]+=1;
                            }
                            else if(l.get(index-1)+60<=time)
                            {
                                  result[j]+=1;
                            }
                         }
                    }  
                }
                else
                {
                   String str[]=list.get(2).split(" ");
                   for(int j=0;j<str.length;j++)
                   {
                    int x=Integer.parseInt(str[j].substring(2));
                    result[x]++;
                   }
                }
            }
            
        }

        return result;
    }
}
