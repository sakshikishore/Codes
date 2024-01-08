class Node
{
    int data;
    int count;
    public Node(int data, int count)
    {
        this.data=data;
        this.count=count;
    }
}
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
       HashSet<Integer> hset=new HashSet<Integer>();
       Queue<Node> q=new LinkedList<Node>();
       Node ptr=new Node(x,0);
       q.add(ptr);
       hset.add(x);
       while(q.size()>0)
       {
           Node node=q.poll();
           int val=node.data;
           int count=node.count;
           if(val==y)
           {
               return count;
           }
 
           if(val%11==0)
           {
               int p=val/11;
               if(p<=10000)
               {
                    Node temp=new Node(p,count+1);
                    if(!hset.contains(p))
                    {
                        hset.add(p);
                        q.add(temp);
                    }
               }
           }
          if(val%5==0)
           {
               int p=val/5;
                if(p<=10000)
                {
                    Node temp=new Node(p,count+1);
                    if(!hset.contains(p))
                    {
                        hset.add(p);
                        q.add(temp);
                    }
                }
           }
           if(val+1<=10000)
           {
            Node temp=new Node(val+1,count+1);
             if(!hset.contains(val+1))
               {
                   hset.add(val+1);
                   q.add(temp);
               }
           }
           if(val-1>=0)
           {
               Node temp=new Node(val-1,count+1);
               if(!hset.contains(val-1))
               {
                   hset.add(val-1);
                   q.add(temp);
               }
           }
       }

       return 0;
    }
}
