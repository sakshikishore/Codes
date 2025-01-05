class Node
    {
        int user,pri;
        public Node(int u, int p)
        {
            user=u;
            pri=p;
        }
    }
class TaskManager {
    HashMap<Integer,Node> h1=new HashMap<Integer,Node>();
    HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
    ArrayList<Integer> al=new ArrayList<Integer>();
    public TaskManager(List<List<Integer>> tasks) {
        for(int i=0;i<tasks.size();i++)
            {
                al.add(tasks.get(i).get(2));
                h1.put(tasks.get(i).get(1),new Node(tasks.get(i).get(0),tasks.get(i).get(2)));
                if(!h2.containsKey(tasks.get(i).get(2)))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(tasks.get(i).get(1));
                    h2.put(tasks.get(i).get(2),l);
                }
                else
                {
                    ArrayList<Integer> l=h2.get(tasks.get(i).get(2));
                    int low=0,high=l.size()-1;
                    int index=0;
                    while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)>tasks.get(i).get(1))
                            {
                                high=mid-1;
                                index=mid;
                            }
                            else
                            {
                                index=mid+1;
                                low=mid+1;
                            }
                        }
                    l.add(index,tasks.get(i).get(1));
                    h2.put(tasks.get(i).get(2),l);
                }
            }

        Collections.sort(al);
    }
    
    public void add(int userId, int taskId, int priority) {
        h1.put(taskId,new Node(userId,priority));
        int min=0,max=al.size()-1;
        while(min<=max)
            {
                int mid=(min+max)/2;
                if(al.get(mid)>priority)
                {
                    max=mid-1;
                }
                else
                {
                    min=mid+1;
                }
            }
        al.add(min,priority);
        if(!h2.containsKey(priority))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(taskId);
                    h2.put(priority,l);
                }
                else
                {
                    ArrayList<Integer> l=h2.get(priority);
                    int low=0,high=l.size()-1;
                    int index=0;
                    while(low<=high)
                        {
                            int mid=(low+high)/2;
                            
                            if(l.get(mid)>taskId)
                            {
                                high=mid-1;
                                index=mid;
                            }
                            else
                            {
                                index=mid+1;
                                low=mid+1;
                            }
                        }
                    l.add(index,taskId);
                    h2.put(priority,l);
                }
    }
    
    public void edit(int taskId, int newPriority) {
        Node node=h1.get(taskId);
        int p=node.pri;
        node.pri=newPriority;
        int min=0,max=al.size()-1;
         while(min<=max)
            {
                int mid=(min+max)/2;
                if(al.get(mid)>p)
                {
                    max=mid-1;
                }
                else if(al.get(mid)<p)
                {
                    min=mid+1;
                }
                else
                {
                    al.remove(mid);
                    break;
                }
            }
        min=0;
        max=al.size()-1;
        while(min<=max)
            {
                int mid=(min+max)/2;
                if(al.get(mid)>newPriority)
                {
                    max=mid-1;
                }
                else
                {
                    min=mid+1;
                }
            }
        al.add(min,newPriority);

        ArrayList<Integer> l=h2.get(p);
        int low=0,high=l.size()-1;
        while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>taskId)
                {
                    high=mid-1;
                }
                else if(l.get(mid)<taskId)
                {
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
            h2.remove(p);
        }
        else
        {
            h2.put(p,l);
        }

        if(!h2.containsKey(newPriority))
                {
                   l=new ArrayList<Integer>();
                    l.add(taskId);
                    h2.put(newPriority,l);
                }
                else
                {
                    l=h2.get(newPriority);
                    low=0;
                    high=l.size()-1;
                    int index=0;
                    while(low<=high)
                        {
                            int mid=(low+high)/2;
                            
                            if(l.get(mid)>taskId)
                            {
                                high=mid-1;
                                index=mid;
                            }
                            else
                            {
                                index=mid+1;
                                low=mid+1;
                            }
                        }
                    l.add(index,taskId);
                    h2.put(newPriority,l);
                }
        
    }
    
    public void rmv(int taskId) {
        Node node=h1.get(taskId);
        int p=node.pri;
        h1.remove(taskId);
        ArrayList<Integer> l=h2.get(p);
        int low=0,high=l.size()-1;
        while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>taskId)
                {
                    high=mid-1;
                }
                else if(l.get(mid)<taskId)
                {
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
            h2.remove(p);
        }
        else
        {
            h2.put(p,l);
        }

         int min=0,max=al.size()-1;
         while(min<=max)
            {
                int mid=(min+max)/2;
                if(al.get(mid)>p)
                {
                    max=mid-1;
                }
                else if(al.get(mid)<p)
                {
                    min=mid+1;
                }
                else
                {
                    al.remove(mid);
                    break;
                }
            }

        
    }
    
    public int execTop() {
        if(al.size()==0)
        {
            return -1;
        }
        int maxPriority=al.get(al.size()-1);
        ArrayList<Integer> l=h2.get(maxPriority);
        int taskId=l.get(l.size()-1);
        Node node=h1.get(taskId);
        int res=node.user;
        int p=node.pri;
        h1.remove(taskId);
        l=h2.get(p);
        int low=0,high=l.size()-1;
        while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>taskId)
                {
                    high=mid-1;
                }
                else if(l.get(mid)<taskId)
                {
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
            h2.remove(p);
        }
        else
        {
            h2.put(p,l);
        }

         int min=0,max=al.size()-1;
         while(min<=max)
            {
                int mid=(min+max)/2;
                if(al.get(mid)>p)
                {
                    max=mid-1;
                }
                else if(al.get(mid)<p)
                {
                    min=mid+1;
                }
                else
                {
                    al.remove(mid);
                    break;
                }
            }

        
        return res;
    }
}
