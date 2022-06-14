class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum=0;
         List<List<Integer>> result=new ArrayList();
        for(int i=0;i<candidates.length;i++)
        {
            sum+=candidates[i];
        }
        if(sum>=target)
        {
        ArrayList<ArrayList<String>> list=new ArrayList();
        for(int i=0;i<=target;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
       int arr[][]=new int[candidates.length][target+1];
        for(int i=0;i<arr.length;i++)
        {
           HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            for(int j=0;j<=target;j++)
            {
                if(j==0)
                {
                    arr[i][j]=1;
                }
                else if(candidates[i]<=j)
                {
                    if(candidates[i]==j)
                    {
                        arr[i][j]=1;
                        if(!list.get(j).contains(Integer.toString(j)))
                        {
                            h.put(j,1);
                            list.get(j).add(Integer.toString(j));
                        }
                    }
                    else
                    {
                        if(i!=0)
                        {
                            int p=j-candidates[i];
                            if(arr[i-1][p]==1)
                            {
                                arr[i][j]=1;
                                int count=0;
                                if(!h.containsKey(p))
                                {
                                    for(int x=0;x<list.get(p).size();x++)
                                    {
                                        String s=list.get(p).get(x)+" "+Integer.toString(candidates[i]);
                                        if(!list.get(j).contains(s))
                                        {
                        list.get(j).add(list.get(p).get(x)+" "+Integer.toString(candidates[i])); 
                                            count++;
                                            }
                                    }
                                     h.put(j,count);
                                }
                                else
                                {
                                    for(int x=0;x<list.get(p).size()-h.get(p);x++)
                                    {
                                        
                                    String s=list.get(p).get(x)+" "+Integer.toString(candidates[i]);
                                        if(!list.get(j).contains(s))
                                        {
                        list.get(j).add(list.get(p).get(x)+" "+Integer.toString(candidates[i])); 
                                            count++;
                                            }
                                    }
                                     h.put(j,count);
                                }
                            }
                            else
                            {
                                if(arr[i-1][j]==1)
                                {
                                    arr[i][j]=1;
                                }
                            }
                        }
                    }
                }
                else
                {
                    if(i!=0)
                    {
                        if(arr[i-1][j]==1)
                        {
                            arr[i][j]=1;
                        }
                    }
                }
            }
        }
        for(int i=0;i<list.get(target).size();i++)
        {
            ArrayList<Integer> al=new ArrayList<Integer>();
            String str[]=list.get(target).get(i).split(" ");
            for(int j=0;j<str.length;j++)
            {
                al.add(Integer.parseInt(str[j]));
            }
            Collections.sort(al);
            if(!result.contains(al))
            {
              result.add(al);
            }
        }
    }
        return result;
    }
}
