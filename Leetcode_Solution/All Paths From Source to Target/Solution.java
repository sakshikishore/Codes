class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList();
        Queue<String> q=new LinkedList<String>();
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<graph[0].length;i++)
        {
           
            String str="0"+" "+Integer.toString(graph[0][i]);
            q.add(str);
        }
        while(q.size()>0)
        {
            String s=q.poll();
            String str[]=s.split(" ");
            int n=str.length-1;
            int x=Integer.parseInt(str[n]);
            if(x==graph.length-1)
            {
                h.add(s);
            }
            else if(graph[x].length==0)
            {
                h.add(s);
            }
            else
            {
                for(int i=0;i<graph[x].length;i++)
                {
                    String p=s+" "+Integer.toString(graph[x][i]);
                    q.add(p);
                }
            }
        }
        
        Iterator<String> itr=h.iterator();
        while(itr.hasNext())
        {
            String s[]=itr.next().split(" ");
            int x=Integer.parseInt(s[s.length-1]);
            if(x==graph.length-1)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                for(int i=0;i<s.length;i++)
                {
                    l.add(Integer.parseInt(s[i]));
                }
                list.add(l);
            }
        }
        
        return list;
        
    }
}
