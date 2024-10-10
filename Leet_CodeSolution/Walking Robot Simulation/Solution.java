class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer,ArrayList<Integer>> mapx=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> mapy=new HashMap<Integer,ArrayList<Integer>>();
        int max=0;
        for(int i=0;i<obstacles.length;i++)
        {
            if(!mapx.containsKey(obstacles[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(obstacles[i][1]);
                mapx.put(obstacles[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=mapx.get(obstacles[i][0]);
                int low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>obstacles[i][1])
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                l.add(low,obstacles[i][1]);
                mapx.put(obstacles[i][0],l);
            }

            if(!mapy.containsKey(obstacles[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(obstacles[i][0]);
                mapy.put(obstacles[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=mapy.get(obstacles[i][1]);
                int low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>obstacles[i][0])
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                l.add(low,obstacles[i][0]);
                mapy.put(obstacles[i][1],l);
            }
        }
        int x=0,y=0;
        char direc='N';
        for(int i=0;i<commands.length;i++)
        {
             if(commands[i]==-1)
             {
                if(direc=='N')
                {
                    direc='E';
                }
                else if(direc=='S')
                {
                    direc='W';
                }
                 else if(direc=='E')
                {
                    direc='S';
                }
                else
                {
                    direc='N';
                }
                
             }
             else if(commands[i]==-2)
             {
                 if(direc=='N')
                {
                    direc='W';
                }
                else if(direc=='S')
                {
                   direc='E';
                }
                 else if(direc=='E')
                {
                    direc='N';
                }
                else
                {
                    direc='S';
                }
             }
             else
             {
                if(direc=='N' || direc=='S')
                {
                    if(mapx.containsKey(x))
                    {
                        ArrayList<Integer> l=mapx.get(x);
                      
                            int low=0,high=l.size()-1;
                            int index=0;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)>y)
                                {
                                    index=mid;
                                    high=mid-1;
                                }
                                 else if(l.get(mid)==y)
                                {
                                    index=mid;
                                    break;
                                }
                                else
                                {
                                    index=mid+1;
                                    low=mid+1;
                                }
                            }
                            if(direc=='N')
                            {
                                if(index<l.size() && l.get(index)==y)
                                {
                                    index=index+1;
                                }
                                if(index==l.size())
                                {
                                     y=y+commands[i];
                                }
                                else if(l.get(index)<=y+commands[i])
                                {
                                    y=l.get(index)-1;
                                }
                                else
                                {
                                     y=y+commands[i];
                                }
                            }
                            else
                            {
                                if(index==0)
                                {
                                    y=y-commands[i];
                                }
                                 else if(l.get(index-1)>=y-commands[i])
                                {
                                    y=l.get(index-1)+1;
                                }
                                else
                                {
                                     y=y-commands[i];
                                }
                            }
                    }
                    else
                    {
                        if(direc=='N')
                        {
                            y=y+commands[i];
                        }
                        else
                        {
                            y=y-commands[i];
                        }
                    }
                }
                else
                {
                 
                    if(mapy.containsKey(y))
                    {
                        ArrayList<Integer> l=mapy.get(y);
                      
                            int low=0,high=l.size()-1;
                            int index=0;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(l.get(mid)>x)
                                {
                                    index=mid;
                                    high=mid-1;
                                }
                                else if(l.get(mid)==x)
                                {
                                    index=mid;
                                    break;
                                }
                                else
                                {
                                    index=mid+1;
                                    low=mid+1;
                                }
                            }
                            if(direc=='E')
                            {
                                if(index<l.size() && l.get(index)==x)
                                {
                                    index=index+1;
                                }
                                if(index==l.size())
                                {
                                     x=x+commands[i];
                                }
                                else if(l.get(index)<=x+commands[i])
                                {
                                    x=l.get(index)-1;
                                }
                                else
                                {
                                     x=x+commands[i];
                                }
                            }
                            else
                            {
                                
                                if(index==0)
                                {
                                    x=x-commands[i];
                                }
                                 else if(l.get(index-1)>=x-commands[i])
                                {
                                    x=l.get(index-1)+1;
                                }
                                else
                                {
                                     x=x-commands[i];
                                }
                            }
                    }
                    else
                    {
                        if(direc=='E')
                        {
                            x=x+commands[i];
                        }
                        else
                        {
                            x=x-commands[i];
                        }
                    }
                
                }
             }
             if((x*x)+(y*y)>max)
             {
                max=(x*x)+(y*y);
             }
             
        }
        return max;
    }
}
