class Node
{
    int course,month;
    public Node(int c, int m)
    {
        course=c;
        month=m;
    }
}
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int max=0;
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<relations.length;i++)
        {
            if(!h1.containsKey(relations[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(relations[i][1]);
                h1.put(relations[i][0],l);
            }
            else
            {
                ArrayList<Integer> l=h1.get(relations[i][0]);
                l.add(relations[i][1]);
                h1.put(relations[i][0],l);
            }
            if(!h2.containsKey(relations[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(relations[i][0]);
                h2.put(relations[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h2.get(relations[i][1]);
                l.add(relations[i][0]);
                h2.put(relations[i][1],l);
            }
        }
        Queue<Node> q=new LinkedList<Node>();
        for(int i=1;i<=n;i++)
        {
            if(!h1.containsKey(i))
            {
                q.add(new Node(i,time[i-1]));
                
            }
        }
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        while(q.size()>0)
        {
            Node node=q.poll();
            if(node.month>max)
            {
                max=node.month;
            }
            if(h2.containsKey(node.course))
            {
                ArrayList<Integer> l=h2.get(node.course);
                for(int i=0;i<l.size();i++)
                {
                    if(!h.containsKey(l.get(i)))
                    {
                        h.put(l.get(i),node.month);
                    }
                    else
                    {
                        h.put(l.get(i),Math.max(h.get(l.get(i)),node.month));
                    }
                    ArrayList<Integer> al=h1.get(l.get(i));
                    al.remove(new Integer(node.course));
                    if(al.size()==0)
                    {
                    h1.remove(al);
                    q.add(new Node(l.get(i),time[l.get(i)-1]+h.get(l.get(i))));
                    }
                }
            }
        }

        return max;


    }
}
