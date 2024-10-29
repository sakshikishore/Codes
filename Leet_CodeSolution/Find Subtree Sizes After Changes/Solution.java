class Node
{
    int data;
    int a[];
    public Node(int n, int ar[])
    {
           data=n;
           a=ar;
    }
}
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        HashMap<Integer,ArrayList<Integer>> hMap=new HashMap<Integer,ArrayList<Integer>>();
        int result[]=new int[parent.length];
        for(int i=1;i<parent.length;i++)
        {
            if(!hMap.containsKey(parent[i]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                hMap.put(parent[i],list);
            }
            else
            {
                ArrayList<Integer> list=hMap.get(parent[i]);
                list.add(i);
                hMap.put(parent[i],list);
            }
           if(!h.containsKey(parent[i]))
           {
            h.put(parent[i],1);
           }
           else
           {
            h.put(parent[i],h.get(parent[i])+1);
           }
        }
        Node treeNode[]=new Node[parent.length];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        int arr[]=new int[26];
        Arrays.fill(arr,-1);
        arr[s.charAt(0)-'a']=0;
        treeNode[0]=new Node(-1,arr);
        while(q.size()>0)
        {
            int x=q.poll();
            Node node=treeNode[x];
            if(hMap.containsKey(x))
            {
                ArrayList<Integer> l=hMap.get(x);
                for(int i=0;i<l.size();i++)
                {
                    int ar[]=new int[26];
                    Arrays.fill(ar,-1);
                    q.add(l.get(i));
                    int b=s.charAt(l.get(i))-'a';
                    int r=-1;
                    if(node.a[b]!=-1)
                    {
                        r=node.a[b];
                    }
                    for(int j=0;j<26;j++)
                    {
                        
                       ar[j]=node.a[j];
                    }
                    ar[b]=l.get(i);
                  treeNode[l.get(i)]=new Node(r,ar);
                }
            }
        }
       q=new LinkedList<Integer>();
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<parent.length;i++)
        {
            if(!h.containsKey(i))
            {
                q.add(i);
                map.put(i,1);
            }
        }
        while(q.size()>0)
        {
            int x=q.poll();
            int val=map.get(x);
            result[x]=val;
            if(parent[x]!=-1)
            {
                h.put(parent[x],h.get(parent[x])-1);
                if(h.get(parent[x])==0)
                {
                    q.add(parent[x]);
                  if(map.containsKey(parent[x]))
                 {
                    map.put(parent[x],1+map.get(parent[x]));
                 }
                 else
                 {
                     map.put(parent[x],1);
                 }
                }
            }
            Node node=treeNode[x];
            int p=node.data;
            if(p==-1)
            {
             
                if(parent[x]!=-1)
                {
                    if(map.containsKey(parent[x]))
                    {
                        map.put(parent[x],val+map.get(parent[x]));
                    }
                    else
                    {
                        map.put(parent[x],val);
                    }
                }
               
            }
            else
            {
                if(map.containsKey(p))
                 {
                    map.put(p,val+map.get(p));
                 }
                 else
                 {
                     map.put(p,val);
                 }
            }
        }

        return result;

    
    }
}
