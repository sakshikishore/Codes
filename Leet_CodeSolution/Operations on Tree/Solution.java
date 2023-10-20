class LockingTree {
     HashMap<Integer,Integer> childParent=new HashMap<Integer,Integer>();
     HashMap<Integer,ArrayList<Integer>> parentChild=new HashMap<Integer,ArrayList<Integer>>();
     HashMap<Integer,Integer> lockMap=new HashMap<Integer,Integer>();
    public LockingTree(int[] parent) {
        for(int i=0;i<parent.length;i++)
        {
           childParent.put(i,parent[i]);
           if(!parentChild.containsKey(parent[i]))
           {
               ArrayList<Integer> l=new ArrayList<Integer>();
               l.add(i);
               parentChild.put(parent[i],l);
           }
           else
           {
               ArrayList<Integer> l=parentChild.get(parent[i]);
               l.add(i);
               parentChild.put(parent[i],l);
           }
        }
        
    }
    
    public boolean lock(int num, int user) {
        if(!lockMap.containsKey(num))
        {
            lockMap.put(num,user);
            return true;
        }

        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lockMap.containsKey(num) && lockMap.get(num)==user)
        {
            lockMap.remove(num);
            return true;
        }

        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(!lockMap.containsKey(num))
        {
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(num);
            while(q.size()>0)
            {
                int node=q.poll();
                if(lockMap.containsKey(node))
                {
                    return false;
                }
                if(childParent.containsKey(node))
                {
                    q.add(childParent.get(node));
                }
            }
            q=new LinkedList<Integer>();
            if(parentChild.containsKey(num))
            {
                ArrayList<Integer> al=parentChild.get(num);
                for(int i=0;i<al.size();i++)
                {
                    q.add(al.get(i));
                }
            }
            else
            {
                return false;
            }
            int count=0;
            while(q.size()>0)
            {
                int node=q.poll();
                if(lockMap.containsKey(node))
                {
                    count=1;
                    lockMap.remove(node);
                }
                if(parentChild.containsKey(node))
                {
                   ArrayList<Integer> al=parentChild.get(node);
                    for(int i=0;i<al.size();i++)
                    {
                        q.add(al.get(i));
                    }
                }
                

            }
            if(count==1)
            {
                lockMap.put(num,user);
                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}
