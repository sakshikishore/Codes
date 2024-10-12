class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hset=new HashSet<String>();
        for(int i=0;i<wordDict.size();i++)
        {
            hset.add(wordDict.get(i));
        }
        int grid[][]=new int[s.length()][s.length()];
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<s.length()-i;j++)
            {
                String str=s.substring(j,j+i+1);
                HashSet<String> hset1=new HashSet<String>();
                ArrayList<String> l=new ArrayList<String>();
                if(hset.contains(str))
                {
                    grid[j][j+i]=1;
                    hset1.add(str);
                }
                 for(int k=j;k<j+i;k++)
                          {
                              if(grid[j][k]==1 && grid[k+1][j+i]==1)
                              {
                                  grid[j][j+i]=1;
                                    ArrayList<String> l1=map.get(Integer.toString(j)+" "+Integer.toString(k));
                                    ArrayList<String> l2=map.get(Integer.toString(k+1)+" "+Integer.toString(j+i));
                                    for(int x=0;x<l1.size();x++)
                                    {
                                        for(int y=0;y<l2.size();y++)
                                        {
                                            hset1.add(l1.get(x)+" "+l2.get(y));
                                        }
                                    }

                              }
                          }
                     if(hset.size()>0)
                     {
                        Iterator<String> itr=hset1.iterator();
                        while(itr.hasNext())
                        {
                          
                            l.add(itr.next());
                        }
                    map.put(Integer.toString(j)+" "+Integer.toString(j+i),l);
                     }
                   
                
            }
        }

             if(grid[0][s.length()-1]==1)
             {
            return map.get(Integer.toString(0)+" "+Integer.toString(s.length()-1));
             }

             return new ArrayList<String>();
        

    }
}
