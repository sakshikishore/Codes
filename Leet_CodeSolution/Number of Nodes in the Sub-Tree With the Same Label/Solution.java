class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
         int result[]=new int[n];
        if(edges.length==0)
        {
            for(int i=0;i<n;i++)
            {
                result[i]=1;
            }

            return result;
        }
        HashMap<Integer,ArrayList<Integer>> h =new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> parentChildren =new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,int[]> map=new HashMap<Integer,int []>();
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        for(int i=0;i<edges.length;i++)
        {
            if(!h.containsKey(edges[i][0]))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(edges[i][1]);
                    h.put(edges[i][0],l);
                }
                else
                {
                    ArrayList<Integer> l=h.get(edges[i][0]);
                    l.add(edges[i][1]);
                    h.put(edges[i][0],l);
                }
            if(!h.containsKey(edges[i][1]))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(edges[i][0]);
                    h.put(edges[i][1],l);
                }
                else
                {
                    ArrayList<Integer> l=h.get(edges[i][1]);
                    l.add(edges[i][0]);
                    h.put(edges[i][1],l);
                }

        }
        Queue<Integer> qu=new LinkedList<Integer>();
        qu.add(0);
        HashSet<Integer> hset=new HashSet<Integer>();
        while(qu.size()>0)
        {
            int x=qu.poll();
            hset.add(x);
            ArrayList<Integer> al=h.get(x);
            for(int i=0;i<al.size();i++)
            {
                if(hset.contains(al.get(i)))
                {
                    al.remove(i);
                    i--;
                }
                else
                {
                    h1.put(al.get(i),x);
                    qu.add(al.get(i));
                }
            }
            if(al.size()>0)
            {
                parentChildren.put(x,al);
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
        {
            int arr[]=new int[26];
            int x=labels.charAt(i)-'a';
            arr[x]=1;
             map.put(i,arr);
            if(!parentChildren.containsKey(i))
            {
                q.add(i);
            }
        }
        while(q.size()>0)
        {
            int node=q.poll();
            int index=labels.charAt(node)-'a';
            int a[]=map.get(node);
            result[node]=a[index];
            if(h1.containsKey(node))
            {
            int parent=h1.get(node);
            ArrayList<Integer> list=parentChildren.get(parent);
            list.remove(Integer.valueOf(node));
            int arr[]=map.get(parent);
            for(int i=0;i<26;i++)
            {
                arr[i]+=a[i];
            }
            map.put(parent,arr);
            if(list.size()==0)
            {
                q.add(parent);
            }
            }
        }

        return result;

    }
}
