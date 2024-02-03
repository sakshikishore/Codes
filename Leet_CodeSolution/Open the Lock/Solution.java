public class Node
{
    int w,x,y,z,count;
    public Node(int w, int x,int y,int z, int count)
    {
        this.w=w;
        this.x=x;
        this.y=y;
        this.z=z;
        this.count=count;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<deadends.length;i++)
        {
            hset.add(Integer.parseInt(deadends[i]));
        }
        if(hset.contains(0))
        {
            return -1;
        }
        HashSet<Integer> visited=new HashSet<Integer>();
        visited.add(0);
        Node node=new Node(0,0,0,0,0);
        Queue<Node> q=new LinkedList<Node>();
        q.add(node);
        int t=Integer.parseInt(target);
        while(q.size()>0)
        {
           node=q.poll();
           int w=node.w, x=node.x,y=node.y,z=node.z,count=node.count; 
           if(w*1000+x*100+y*10+z==t)
           {
               return count;
           }
               
               int val=((w+1)%10)*1000+x*100+y*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node((w+1)%10,x,y,z,count+1));
                  visited.add(val);
               }
               val=((w-1+10)%10)*1000+x*100+y*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node((w-1+10)%10,x,y,z,count+1));
                    visited.add(val);
               }
               val=w*1000+((x+1)%10)*100+y*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,(x+1)%10,y,z,count+1));
                    visited.add(val);
               }
               val=w*1000+((x-1+10)%10)*100+y*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,(x-1+10)%10,y,z,count+1));
                    visited.add(val);
               }
               val=w*1000+x*100+((y+1)%10)*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,x,(y+1)%10,z,count+1));
                    visited.add(val);
               }
               val=w*1000+x*100+((y-1+10)%10)*10+z;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,x,(y-1+10)%10,z,count+1));
                    visited.add(val);
               }
               val=w*1000+x*100+y*10+(z+1)%10;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,x,y,(z+1)%10,count+1));
                   visited.add(val);
               }
               val=w*1000+x*100+y*10+(z-1+10)%10;
               if(!visited.contains(val) && !hset.contains(val))
               {
                  q.add(new Node(w,x,y,(z-1+10)%10,count+1));
                    visited.add(val);
               }

        }

        return -1;

    }
}
