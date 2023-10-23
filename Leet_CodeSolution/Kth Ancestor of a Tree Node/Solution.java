class TreeAncestor {
    HashMap<Integer,Integer> h;
    HashMap<Integer,Integer> nodeLeaf=new HashMap<Integer,Integer>();
    HashSet<Integer> hset=new HashSet<Integer>();
    ArrayList<Integer> leaf=new ArrayList<Integer>();
    HashMap<Integer,ArrayList<Integer>> leafAncestor=new HashMap<Integer,ArrayList<Integer>>();
    public TreeAncestor(int n, int[] parent) {
        h=new HashMap<Integer,Integer>();
        for(int i=0;i<parent.length;i++)
        {
            hset.add(parent[i]);
            h.put(i,parent[i]);
        }
        for(int i=0;i<n;i++)
        {
            if(!hset.contains(i))
            {
                leaf.add(i);
            }
        }
        for(int i=0;i<leaf.size();i++)
        {

           int p=h.get(leaf.get(i));
            nodeLeaf.put(leaf.get(i),leaf.get(i));
           ArrayList<Integer> l=new ArrayList<Integer>();
           l.add(leaf.get(i));
           l.add(p);
           Queue<Integer> q=new LinkedList<Integer>();
           q.add(p);
           nodeLeaf.put(p,leaf.get(i));
           while(q.size()>0)
           {
               int node=q.poll();
               p=h.get(node);
               l.add(p);
               nodeLeaf.put(p,leaf.get(i));
               if(p==-1)
               {
                   break;
               }
               q.add(p);
           }
           leafAncestor.put(leaf.get(i),l);
        }
    }
    
    public int getKthAncestor(int node, int k) {
       int leaf=nodeLeaf.get(node);
       ArrayList<Integer> list=leafAncestor.get(leaf);
       int index=list.indexOf(node);
       int p=list.size()-index;
       if(p<=k)
       {
           return -1;
       }
       else
       {
           return list.get(index+k);
       }
    }
}
