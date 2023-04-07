class Solution {
    public int removeStones(int[][] stones) {
        int result=0;
        HashSet<String> h=new HashSet<String>();
        HashMap<Integer,ArrayList<Integer>> hrow=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> hcol=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<stones.length;i++)
        {
            int x=stones[i][0];
            int y=stones[i][1];
            if(!hrow.containsKey(x))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                hrow.put(x,l);
            }
            else
            {
                ArrayList<Integer> l=hrow.get(x);
                l.add(i);
                hrow.put(x,l);
            }
            if(!hcol.containsKey(y))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                hcol.put(y,l);
            }
            else
            {
                ArrayList<Integer> l=hcol.get(y);
                l.add(i);
                hcol.put(y,l);
            }
        }
        for(int i=0;i<stones.length;i++)
        {
            String s=Integer.toString(stones[i][0])+" "+Integer.toString(stones[i][1]);
            if(!h.contains(s))
            {
                Queue<String> q=new LinkedList<String>();
                h.add(s);
                q.add(s);
                int count=0;
                while(q.size()>0)
                {
                    String str[]=q.poll().split(" ");
                    count++;
                    int x=Integer.parseInt(str[0]);
                    int y=Integer.parseInt(str[1]);
                    ArrayList<Integer> row=hrow.get(x);
                    for(int j=0;j<row.size();j++)
                    {
                        int p=row.get(j);
                        s=Integer.toString(stones[p][0])+" "+Integer.toString(stones[p][1]);
                        if(!h.contains(s))
                        {
                            h.add(s);
                            q.add(s);
                        }
                    }
                    ArrayList<Integer> col=hcol.get(y);
                    for(int j=0;j<col.size();j++)
                    {
                        int p=col.get(j);
                        s=Integer.toString(stones[p][0])+" "+Integer.toString(stones[p][1]);
                        if(!h.contains(s))
                        {
                            h.add(s);
                            q.add(s);
                        }
                    }

                }
                result+=count-1;
            }
        }

        return result;
    }
}
