public class Node
{
    int start,end,count;
    public Node(int s, int e, int c)
    {
        start=s;
        end=e;
        count=c;
    }
}
class Solution {
    public int videoStitching(int[][] clips, int time) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<clips.length;i++)
        {
            if(!map.containsKey(clips[i][0]))
            {
                map.put(clips[i][0],clips[i][1]);
            }
            else
            {
                 if(map.get(clips[i][0])<clips[i][1])
                 {
                    map.put(clips[i][0],clips[i][1]);
                 }
            }
        }
        //System.out.println(map);
      if(!map.containsKey(0))
      {
        return -1;
      }
      Queue<Node> q=new LinkedList<Node>();
      int x=map.get(0);
      int result=Integer.MAX_VALUE;
      q.add(new Node(0,x,1));
      while(q.size()>0)
      {
         Node node=q.poll();
         x=node.end;
         if(x>=time)
         {
            result=Math.min(result,node.count);
         }
         else
         {
            int max=-1;
            for(int i=node.start+1;i<=x;i++)
            {
              if(map.containsKey(i))
              {
                if(map.get(i)>x && map.get(i)>max)
                {
                   max=map.get(i);
                }
              }
            }
            if(max!=-1)
            {
                q.add(new Node(x,max,node.count+1));
            }
         }
      }

      if(result==Integer.MAX_VALUE)
      {
        return -1;
      }

      return result;
    }
}
