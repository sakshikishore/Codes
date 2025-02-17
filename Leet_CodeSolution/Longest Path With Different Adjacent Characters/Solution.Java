class Solution {
    public int longestPath(int[] parent, String s) {
    HashMap<Integer,ArrayList<Integer>>  h=new  HashMap<Integer,ArrayList<Integer>>();
    HashMap<Integer,Integer>  maxLen=new HashMap<Integer,Integer>();
    int arr[]=new int[parent.length];
    int max=1;
    for(int i=1;i<parent.length;i++)
    {
         arr[parent[i]]++;
        if(!h.containsKey(parent[i]))
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(i);
            h.put(parent[i],l);
        }
        else
        {
            ArrayList<Integer> l=h.get(parent[i]);
            l.add(i);
            h.put(parent[i],l);
        }
    }
   Queue<Integer> q=new LinkedList<Integer>();
    for(int i=0;i<parent.length;i++)
    {
        if(!h.containsKey(i))
        {
            q.add(i);
        }
    }
    while(q.size()>0)
    {
        int x=q.poll();
        if(!h.containsKey(x))
        {
            maxLen.put(x,1);         
        }
        else
        {
            ArrayList<Integer> al=new ArrayList<Integer>();
            ArrayList<Integer> l=h.get(x);
            for(int i=0;i<l.size();i++)
            {
                int child=l.get(i);
                if(s.charAt(child)!=s.charAt(x))
                {
                    al.add(maxLen.get(child));
                }
            }
            if(al.size()==0)
            {
                 maxLen.put(x,1);
            }
            else
            {
                if(al.size()==1)
                {
                    maxLen.put(x,al.get(0)+1);
                    if(al.get(0)+1>max)
                    {
                        max=al.get(0)+1;
                    }
                }
                else
                {
                    Collections.sort(al);
                    if(al.get(al.size()-1)+al.get(al.size()-2)+1>max)
                    {
                        max=al.get(al.size()-1)+al.get(al.size()-2)+1;
                    }
                     maxLen.put(x,al.get(al.size()-1)+1);
                }
            }
            
        }
        if(parent[x]!=-1)
        {
            arr[parent[x]]--;
            if(arr[parent[x]]==0)
            {
                q.add(parent[x]);
            }
        }
    }

    return max;


    }
}
