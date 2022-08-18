class Solution {
    public int[][] findFarmland(int[][] land) {
        HashSet<String> h=new HashSet<String>();
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<land.length;i++)
        {
            for(int j=0;j<land[i].length;j++)
            {
                if(land[i][j]==1)
                {
                    String s=Integer.toString(i)+" "+Integer.toString(j);
                    if(!h.contains(s))
                    {
                        int a=i,b=j;
                        h.add(s);
                        Queue<String> q=new LinkedList<String>();
                        q.add(s);
                        while(q.size()>0)
                        {
                            String str[]=q.poll().split(" ");
                            int x=Integer.parseInt(str[0]);
                            int y=Integer.parseInt(str[1]);
                            if(x-1>=0 && land[x-1][y]==1)
                            {
                               s=Integer.toString(x-1)+" "+Integer.toString(y);
                                if(!h.contains(s))
                                {
                                   q.add(s);
                                   h.add(s);
                                }
                            }
                            if(y-1>=0 && land[x][y-1]==1)
                            {
                               s=Integer.toString(x)+" "+Integer.toString(y-1);
                               if(!h.contains(s))
                                {
                                   q.add(s);
                                   h.add(s);
                                }
                            }
                            if(y+1<land[i].length && land[x][y+1]==1)
                            {
                               s=Integer.toString(x)+" "+Integer.toString(y+1);
                               if(!h.contains(s))
                                {
                                   q.add(s);
                                   h.add(s);
                                }
                            }
                            if(x+1<land.length && land[x+1][y]==1)
                            {
                               s=Integer.toString(x+1)+" "+Integer.toString(y);
                               if(!h.contains(s))
                                {
                                   q.add(s);
                                   h.add(s);
                                }
                            }
                            
                            if(q.size()==0)
                            {

                                ArrayList<Integer> l=new ArrayList<Integer>();
                                l.add(a);
                                l.add(b);
                                l.add(x);
                                l.add(y);
                                list.add(l);
                            }
                        }
                    }
                }
            }
        }
        int arr[][]=new int[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            arr[i][0]=list.get(i).get(0);
            arr[i][1]=list.get(i).get(1);
            arr[i][2]=list.get(i).get(2);
            arr[i][3]=list.get(i).get(3);
            
        }
        
        return arr;
    }
}
