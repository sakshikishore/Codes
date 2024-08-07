class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int result[]=new int[tasks.length];
        HashMap<Integer,ArrayList<Integer>> h1=new  HashMap<Integer,ArrayList<Integer>>();
         HashMap<Integer,ArrayList<Integer>> h2=new  HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> freeServer=new PriorityQueue<Integer>(); 
        for(int i=0;i<servers.length;i++)
        {
                freeServer.add(servers[i]);
                if(!h1.containsKey(servers[i]))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    h1.put(servers[i],list);
                }
                else
                {
                    ArrayList<Integer> list=h1.get(servers[i]);
                    list.add(i);
                    h1.put(servers[i],list);
                }
        }
        PriorityQueue<Integer> nonFreeServer=new PriorityQueue<Integer>(); 
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        int time=0;
        while(q.size()>0)
        {
            while(nonFreeServer.size()>0 && nonFreeServer.peek()<=time)
            {
                int p=nonFreeServer.poll();
                ArrayList<Integer> al=h2.get(p);
                h2.remove(p);
                for(int i=0;i<al.size();i++)
                {
                    freeServer.add(servers[al.get(i)]);
                    if(h1.containsKey(servers[al.get(i)]))
                    {
                        ArrayList<Integer> alist=h1.get(servers[al.get(i)]);
                        int low=0,high=alist.size()-1;
                        while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(alist.get(mid)>al.get(i))
                            {
                                high=mid-1;
                            }
                            else
                            {
                                low=mid+1;
                            }
                        }
                        alist.add(low,al.get(i));
                        h1.put(servers[al.get(i)],alist);
                    }
                    else
                    {
                        ArrayList<Integer> alist=new ArrayList<Integer>();
                        alist.add(al.get(i));
                        h1.put(servers[al.get(i)],alist);

                    }
                }
                
            }
                 
               
               while(q.size()>0 && freeServer.size()!=0)
               {
                    int j=q.poll();
                    int x= freeServer.poll();
                    ArrayList<Integer> l=h1.get(x);
                    result[j]=l.get(0);
                    l.remove(0);
                    h1.put(x,l);
                    if(!h2.containsKey(time+tasks[j]))
                    {
                        ArrayList<Integer> list=new ArrayList<Integer>();
                        list.add(result[j]);
                        nonFreeServer.add(time+tasks[j]);
                        h2.put(time+tasks[j],list);

                    }
                    else
                    {
                        ArrayList<Integer> list=h2.get(time+tasks[j]);
                            int low=0,high=list.size()-1;
                            while(low<=high)
                            {
                                int mid=(low+high)/2;
                                if(list.get(mid)>result[j])
                                {
                                    high=mid-1;
                                }
                                else
                                {
                                    low=mid+1;
                                }
                            }
                            list.add(low,result[j]);
                        h2.put(time+tasks[j],list);
                    }
            }
               if(freeServer.size()==0)
               {
                    int t=nonFreeServer.peek();
                    for(int y=time+1;y<=t && y<tasks.length;y++)
                    {
                        q.add(y);
                    }
                    time=t;

               }
               else
               {
                    time++;
                    if(time<tasks.length)
                    {
                        q.add(time);
                    }
               }
            
        }

        return result;
    }
}
