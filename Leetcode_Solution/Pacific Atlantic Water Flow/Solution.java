class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[i].length;j++)
            {
                    boolean PO=false,AO=false;
                    if((i==0 && j==heights[0].length-1)|| (i==heights.length-1 && j==0))
                    {
                        ArrayList<Integer> al=new ArrayList<Integer>();
                        al.add(i);
                        al.add(j);
                        list.add(al);
                    }
                else
                {
                    HashSet<String> h=new HashSet<String>();
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    h.add(str);
                    Queue<String> q=new LinkedList<String>();
                    q.add(str);
                    while(q.size()>0)
                    {
                        String s[]=q.poll().split(" ");
                        int x=Integer.parseInt(s[0]);
                        int y=Integer.parseInt(s[1]);
                        if(x==0 || y==0)
                        {
                            PO=true;
                        }
                        if(x==heights.length-1 || y==heights[i].length-1)
                        {
                            AO=true;
                        }
                        if(AO && PO)
                        {
                          ArrayList<Integer> al=new ArrayList<Integer>();
                          al.add(i);
                          al.add(j);
                          list.add(al);
                          break;
                        }
                        if(x-1>=0)
                        {
                            if(heights[x-1][y]<=heights[x][y])
                            {
                                str=Integer.toString(x-1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                        }
                        if(y-1>=0)
                        {
                            if(heights[x][y-1]<=heights[x][y])
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y-1);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                        }
                        if(x+1<heights.length)
                        {
                            if(heights[x+1][y]<=heights[x][y])
                            {
                                str=Integer.toString(x+1)+" "+Integer.toString(y);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                        }
                        if(y+1<heights[0].length)
                        {
                            if(heights[x][y+1]<=heights[x][y])
                            {
                                str=Integer.toString(x)+" "+Integer.toString(y+1);
                                if(!h.contains(str))
                                {
                                    h.add(str);
                                    q.add(str);
                                }
                            }
                        }
                        
                    }
                }
                
            }
        }
        
        return list;
    }
}
